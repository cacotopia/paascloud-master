package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.TpcMqProducer;
import com.supos.cloud.provider.model.vo.TpcMqProducerVo;
import com.supos.cloud.provider.model.vo.TpcMqPublishVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Tpc mq producer mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface TpcMqProducerMapper extends MyMapper<TpcMqProducer> {

	/**
	 * 查询生产者集合.
	 *
	 * @param tpcMqProducer the tpc mq producer
	 *
	 * @return the list
	 */
	List<TpcMqProducerVo> listTpcMqProducerVoWithPage(TpcMqProducer tpcMqProducer);

	/**
	 * 查询发布消息集合.
	 *
	 * @param tpcMqProducer the tpc mq producer
	 *
	 * @return the list
	 */
	List<TpcMqPublishVo> listTpcMqPublishVoWithPage(TpcMqProducer tpcMqProducer);

	/**
	 * Delete publish by producer id int.
	 *
	 * @param producerId the producer id
	 *
	 * @return the int
	 */
	int deletePublishByProducerId(@Param("producerId") Long producerId);

	/**
	 * Gets by pid.
	 *
	 * @param producerGroup the producer group
	 *
	 * @return the by pid
	 */
	TpcMqProducer getByPid(@Param("pid") String producerGroup);

}