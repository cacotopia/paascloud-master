package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.TpcMqTopic;
import com.supos.cloud.provider.model.vo.TpcMqTopicVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Tpc mq topic mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface TpcMqTopicMapper extends MyMapper<TpcMqTopic> {
	/**
	 * List tpc mq topic vo with page list.
	 *
	 * @param tpcMqTopic the tpc mq topic
	 *
	 * @return the list
	 */
	List<TpcMqTopicVo> listTpcMqTopicVoWithPage(TpcMqTopic tpcMqTopic);
}