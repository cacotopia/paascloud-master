package com.supos.cloud.provider.consumer.listener;

import com.supos.cloud.PublicUtil;
import com.supos.cloud.base.constant.AliyunMqTopicConstants;
import com.supos.cloud.core.mq.MqMessage;
import com.supos.cloud.provider.annotation.MqConsumerStore;
import com.supos.cloud.provider.consumer.MdcTopicConsumer;
import com.supos.cloud.provider.consumer.OptSendEmailTopicConsumer;
import com.supos.cloud.provider.consumer.OptSendSmsTopicConsumer;
import com.supos.cloud.provider.model.service.MqMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The class Opt push message listener.
 *
 * @author walkman
 */
@Slf4j
@Component
public class OptPushMessageListener implements MessageListenerConcurrently {

	@Resource
	private OptSendSmsTopicConsumer optSendSmsTopicService;
	@Resource
	private OptSendEmailTopicConsumer optSendEmailTopicService;
	@Resource
	private MdcTopicConsumer mdcTopicConsumer;

	@Resource
	private MqMessageService mqMessageService;
	@Resource
	private StringRedisTemplate srt;

	/**
	 * Consume message consume concurrently status.
	 *
	 * @param messageExtList             the message ext list
	 * @param consumeConcurrentlyContext the consume concurrently context
	 *
	 * @return the consume concurrently status
	 */
	@Override
	@MqConsumerStore
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messageExtList, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
		MessageExt msg = messageExtList.get(0);
		String body = new String(msg.getBody());
		String topicName = msg.getTopic();
		String tags = msg.getTags();
		String keys = msg.getKeys();
		log.info("MQ消费Topic={},tag={},key={}", topicName, tags, keys);
		ValueOperations<String, String> ops = srt.opsForValue();
		// 控制幂等性使用的key
		try {
			MqMessage.checkMessage(body, topicName, tags, keys);
			String mqKV = null;
			if (srt.hasKey(keys)) {
				mqKV = ops.get(keys);
			}
			if (PublicUtil.isNotEmpty(mqKV)) {
				log.error("MQ消费Topic={},tag={},key={}, 重复消费", topicName, tags, keys);
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
			if (AliyunMqTopicConstants.MqTopicEnum.SEND_SMS_TOPIC.getTopic().equals(topicName)) {
				optSendSmsTopicService.handlerSendSmsTopic(body, topicName, tags, keys);
			}
			if (AliyunMqTopicConstants.MqTopicEnum.SEND_EMAIL_TOPIC.getTopic().equals(topicName)) {
				optSendEmailTopicService.handlerSendEmailTopic(body, topicName, tags, keys);
			}
			if (AliyunMqTopicConstants.MqTopicEnum.TPC_TOPIC.getTopic().equals(topicName)) {
				mqMessageService.deleteMessageTopic(body, tags);
			}
			if (AliyunMqTopicConstants.MqTopicEnum.MDC_TOPIC.getTopic().equals(topicName)) {
				mdcTopicConsumer.handlerSendSmsTopic(body, topicName, tags, keys);
			} else {
				log.info("OPC订单信息消 topicName={} 不存在", topicName);
			}
		} catch (IllegalArgumentException ex) {
			log.error("校验MQ message 失败 ex={}", ex.getMessage(), ex);
		} catch (Exception e) {
			log.error("处理MQ message 失败 topicName={}, keys={}, ex={}", topicName, keys, e.getMessage(), e);
			return ConsumeConcurrentlyStatus.RECONSUME_LATER;
		}
		ops.set(keys, keys, 10, TimeUnit.DAYS);
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}
}
