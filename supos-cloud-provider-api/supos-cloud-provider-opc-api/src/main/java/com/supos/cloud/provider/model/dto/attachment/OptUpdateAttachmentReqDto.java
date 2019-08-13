package com.supos.cloud.provider.model.dto.attachment;

import lombok.Data;

import java.io.Serializable;

/**
 * The class Opt update attachment req dto.
 *
 * @author walkman
 */
@Data
public class OptUpdateAttachmentReqDto implements Serializable {

	private static final long serialVersionUID = -1727131719075160349L;

	/**
	 * 附件流水号
	 */
	private String serialNo;

	/**
	 * 上传附件的相关业务流水号
	 */
	private String refNo;

	private Long userId;

	private String userName;

}
