package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.service.OpcOssFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import com.supos.cloud.provider.model.dto.oss.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The class Opc oss feign api hystrix.
 *
 * @author walkman
 */
@Component
public class OpcOssFeignApiHystrix implements OpcOssFeignApi {
	@Override
	public Wrapper<OptUploadFileRespDto> uploadFile(final OptUploadFileReqDto optUploadFileReqDto) {
		return null;
	}

	@Override
	public Wrapper<String> getFileUrl(final OptGetUrlRequest optGetUrlRequest) {
		return null;
	}

	@Override
	public Wrapper<List<ElementImgUrlDto>> listFileUrl(final OptBatchGetUrlRequest urlRequest) {
		return null;
	}

	@Override
	public Wrapper<OptUploadFileRespDto> handleFileUpload(final MultipartFile file) {
		return null;
	}

	@Override
	public void deleteExpireFile() {

	}
}
