package com.supos.cloud.provider.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The class Mdc mq consumer vo.
 *
 * @author walkman
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TpcMqConsumerVo extends TpcMqSubscribeVo {
	private static final long serialVersionUID = 8833595265432073801L;

	/**
	 * 订阅Topic集合
	 */
	private List<TpcMqTopicVo> mqTopicVoList;

}
