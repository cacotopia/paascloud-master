//
//package com.supos.cloud.provider.job.simple;
//
//import com.alibaba.fastjson.JSON;
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.supos.cloud.base.constant.AliyunMqTopicConstants;
//import com.supos.cloud.base.dto.ShardingContextDto;
//import com.supos.cloud.config.properties.PaascloudProperties;
//import com.supos.cloud.core.generator.UniqueIdGenerator;
//import com.supos.cloud.elastic.lite.annotation.ElasticJobConfig;
//import com.supos.cloud.provider.model.dto.TpcMqMessageDto;
//import com.supos.cloud.provider.model.service.TpcMqMessageService;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.annotation.Resource;
//
///**
// * 定时清理所有订阅者消费成功的消息数据.
// *
// * @author walkman
// */
//@Slf4j
//@ElasticJobConfig(cron = "0 0 0 1/1 * ?")
//public class DeleteRpcConsumerMessageJob implements SimpleJob {
//	@Resource
//	private PaascloudProperties paascloudProperties;
//	@Resource
//	private TpcMqMessageService tpcMqMessageService;
//
//	/**
//	 * Execute.
//	 *
//	 * @param shardingContext the sharding context
//	 */
//	@Override
//	public void execute(final ShardingContext shardingContext) {
//		ShardingContextDto shardingContextDto = new ShardingContextDto(shardingContext.getShardingTotalCount(), shardingContext.getShardingItem());
//		final TpcMqMessageDto message = new TpcMqMessageDto();
//		message.setMessageBody(JSON.toJSONString(shardingContextDto));
//		message.setMessageTag(AliyunMqTopicConstants.MqTagEnum.DELETE_CONSUMER_MESSAGE.getTag());
//		message.setMessageTopic(AliyunMqTopicConstants.MqTopicEnum.TPC_TOPIC.getTopic());
//		message.setProducerGroup(paascloudProperties.getAliyun().getRocketMq().getProducerGroup());
//		String refNo = Long.toString(UniqueIdGenerator.generateId());
//		message.setRefNo(refNo);
//		message.setMessageKey(refNo);
//		tpcMqMessageService.saveAndSendMessage(message);
//	}
//}
