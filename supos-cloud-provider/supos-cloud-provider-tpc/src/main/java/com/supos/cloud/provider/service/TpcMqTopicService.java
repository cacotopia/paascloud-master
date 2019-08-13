package com.supos.cloud.provider.service;

import com.supos.cloud.core.support.IService;
import com.supos.cloud.provider.model.domain.TpcMqTopic;
import com.supos.cloud.provider.model.vo.TpcMqTopicVo;

import java.util.List;

/**
 * The interface Tpc mq topic service.
 *
 * @author walkman
 */
public interface TpcMqTopicService extends IService<TpcMqTopic> {
	/**
	 * 查询MQ topic列表.
	 *
	 * @param mdcMqTopic the mdc mq topic
	 *
	 * @return the list
	 */
	List<TpcMqTopicVo> listWithPage(TpcMqTopic mdcMqTopic);

}
