package com.supos.cloud.provider.service.impl;

import com.supos.cloud.base.enums.ErrorCodeEnum;
import com.supos.cloud.provider.model.exceptions.OmcBizException;
import com.supos.cloud.provider.model.dto.oss.OptGetUrlRequest;
import com.supos.cloud.provider.model.dto.oss.OptUploadFileReqDto;
import com.supos.cloud.provider.model.dto.oss.OptUploadFileRespDto;
import com.supos.cloud.provider.model.service.OpcOssFeignApi;
import com.supos.cloud.provider.service.OpcOssService;
import com.supos.cloud.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The class Opc oss service.
 *
 * @author walkman
 */
@Slf4j
@Service
public class OpcOssServiceImpl implements OpcOssService {
	@Resource
	private OpcOssFeignApi opcOssFeignApi;

	@Override
	public OptUploadFileRespDto uploadFile(OptUploadFileReqDto optUploadFileReqDto) {
		log.info("uploadFile - 上传附件. optUploadFileReqDto={}", optUploadFileReqDto);
		Wrapper<OptUploadFileRespDto> wrapper = opcOssFeignApi.uploadFile(optUploadFileReqDto);
		if (null == wrapper || wrapper.error()) {
			throw new OmcBizException(ErrorCodeEnum.OMC10031012);
		}
		return wrapper.getResult();
	}

	@Override
	public String getFileUrl(OptGetUrlRequest optGetUrlRequest) {
		log.info("getFileUrl - 获取附件地址. optUploadFileReqDto={}", optGetUrlRequest);
		Wrapper<String> wrapper = opcOssFeignApi.getFileUrl(optGetUrlRequest);
		if (null == wrapper || wrapper.error()) {
			throw new OmcBizException(ErrorCodeEnum.OMC10031013);
		}
		return wrapper.getResult();
	}
}
