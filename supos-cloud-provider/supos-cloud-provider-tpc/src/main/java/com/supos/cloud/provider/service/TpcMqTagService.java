package com.supos.cloud.provider.service;

import com.supos.cloud.core.support.IService;
import com.supos.cloud.provider.model.domain.TpcMqTag;
import com.supos.cloud.provider.model.vo.TpcMqTagVo;

import java.util.List;

/**
 * The interface Tpc mq tag service.
 *
 * @author walkman
 */
public interface TpcMqTagService extends IService<TpcMqTag> {
	/**
	 * 查询Tag列表.
	 *
	 * @param mdcMqTag the mdc mq tag
	 *
	 * @return the list
	 */
	List<TpcMqTagVo> listWithPage(TpcMqTag mdcMqTag);

	/**
	 * 根据ID删除TAG.
	 *
	 * @param tagId the tag id
	 *
	 * @return the int
	 */
	int deleteTagById(Long tagId);
}
