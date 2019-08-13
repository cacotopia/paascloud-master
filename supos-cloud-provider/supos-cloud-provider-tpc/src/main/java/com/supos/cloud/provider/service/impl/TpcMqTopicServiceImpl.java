package com.supos.cloud.provider.service.impl;

import com.supos.cloud.core.support.BaseService;
import com.supos.cloud.provider.mapper.TpcMqTopicMapper;
import com.supos.cloud.provider.model.domain.TpcMqTopic;
import com.supos.cloud.provider.model.vo.TpcMqTopicVo;
import com.supos.cloud.provider.service.TpcMqTopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Tpc mq topic service.
 *
 * @author walkman
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TpcMqTopicServiceImpl extends BaseService<TpcMqTopic> implements TpcMqTopicService {
	@Resource
	private TpcMqTopicMapper mdcMqTopicMapper;

	@Override
	public List<TpcMqTopicVo> listWithPage(TpcMqTopic mdcMqTopic) {
		return mdcMqTopicMapper.listTpcMqTopicVoWithPage(mdcMqTopic);
	}
}
