package com.supos.cloud.provider.service;

import com.supos.cloud.provider.model.dto.oss.OptGetUrlRequest;
import com.supos.cloud.provider.model.dto.oss.OptUploadFileReqDto;
import com.supos.cloud.provider.model.dto.oss.OptUploadFileRespDto;

/**
 * The interface Opc oss service.
 *
 * @author walkman
 */
public interface OpcOssService {
	/**
	 * Upload file opt upload file resp dto.
	 *
	 * @param optUploadFileReqDto the opt upload file req dto
	 *
	 * @return the opt upload file resp dto
	 */
	OptUploadFileRespDto uploadFile(OptUploadFileReqDto optUploadFileReqDto);

	/**
	 * Gets file url.
	 *
	 * @param optGetUrlRequest the opt get url request
	 *
	 * @return the file url
	 */
	String getFileUrl(OptGetUrlRequest optGetUrlRequest);
}
