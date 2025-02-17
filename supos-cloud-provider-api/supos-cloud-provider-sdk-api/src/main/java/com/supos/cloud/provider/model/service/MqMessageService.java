package com.supos.cloud.provider.model.service;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.MessageQueryDto;
import com.supos.cloud.base.dto.MqMessageVo;
import com.supos.cloud.provider.model.domain.MqMessageData;
import com.supos.cloud.provider.model.enums.MqSendTypeEnum;
import com.supos.cloud.wrapper.Wrapper;

import java.util.List;

/**
 * The interface Tpc mq message feign api.
 *
 * @author walkman
 */
public interface MqMessageService {

	/**
	 * 保存生产者信息.
	 *
	 * @param mqMessageData the mq message data
	 */
	void saveMqProducerMessage(MqMessageData mqMessageData);

	/**
	 * Confirm and send message.
	 *
	 * @param messageKey the message key
	 */
	void confirmAndSendMessage(String messageKey);

	/**
	 * 保存消费者信息.
	 *
	 * @param mqMessageData the mq message data
	 */
	void saveMqConsumerMessage(MqMessageData mqMessageData);

	/**
	 * 根据messageKey删除消息记录.
	 *
	 * @param messageKey the message key
	 * @param type       the type
	 */
	void deleteMessageByMessageKey(String messageKey, MqSendTypeEnum type);

	/**
	 * Confirm receive message.
	 *
	 * @param cid 消费者分组id
	 * @param dto the dto
	 */
	void confirmReceiveMessage(String cid, MqMessageData dto);

	/**
	 * Save and confirm finish message.
	 *
	 * @param cid        消费者分组id
	 * @param messageKey the message key
	 */
	void saveAndConfirmFinishMessage(String cid, String messageKey);

	/**
	 * Delete mq producer message.
	 *
	 * @param shardingTotalCount the sharding total count
	 * @param shardingItem       the sharding item
	 * @param tags               the tags
	 */
	void deleteMqMessage(int shardingTotalCount, int shardingItem, String tags);

	/**
	 * Delete message topic.
	 *
	 * @param body the body
	 * @param tags the tags
	 */
	void deleteMessageTopic(String body, String tags);

	/**
	 * 查询含有的messageKey.
	 *
	 * @param messageKeyList the message key list
	 *
	 * @return the wrapper
	 */
	List<String> queryMessageKeyList(List<String> messageKeyList);

	/**
	 * 保存等待确认的消息(前置拦截器).
	 *
	 * @param mqMessageData the mq message data
	 */
	void saveWaitConfirmMessage(MqMessageData mqMessageData);


	/**
	 * 保存并发送消息(后置拦截器).
	 *
	 * @param mqMessageData the mq message data
	 */
	void saveAndSendMessage(MqMessageData mqMessageData);

	/**
	 * 直接发送消息(后置拦截器).
	 *
	 * @param mqMessageData the mq message data
	 */
	void directSendMessage(MqMessageData mqMessageData);

	/**
	 * Query message list with page wrapper.
	 *
	 * @param messageQueryDto the message query dto
	 *
	 * @return the wrapper
	 */
	Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(MessageQueryDto messageQueryDto);
}
