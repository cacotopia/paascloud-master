package com.supos.cloud.provider.model.vo;

import com.supos.cloud.base.dto.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class Mdc mq tag vo.
 *
 * @author walkman
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TpcMqTagVo extends BaseVo {
	private static final long serialVersionUID = -4176095424582783954L;
	/**
	 * 主题ID
	 */
	private Long topicId;

	/**
	 * 主题编码
	 */
	private String topicCode;

	/**
	 * 主题名称
	 */
	private String topicName;

	/**
	 * 城市编码
	 */
	private String tagCode;

	/**
	 * 区域编码
	 */
	private String tagName;

	/**
	 * 状态, 0生效,10,失效
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;
}
