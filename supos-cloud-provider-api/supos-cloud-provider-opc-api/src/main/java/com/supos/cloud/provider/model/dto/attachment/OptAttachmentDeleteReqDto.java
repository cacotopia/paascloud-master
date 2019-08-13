package com.supos.cloud.provider.model.dto.attachment;

import lombok.Data;

import java.io.Serializable;

/**
 * The class Opt attachment delete req dto.
 *
 * @author walkman
 */
@Data
public class OptAttachmentDeleteReqDto implements Serializable {


	private static final long serialVersionUID = 731160897713227519L;
	private String[] serialNos;
}
