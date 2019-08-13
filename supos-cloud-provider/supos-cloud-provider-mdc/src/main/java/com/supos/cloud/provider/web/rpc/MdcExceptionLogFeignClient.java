package com.supos.cloud.provider.web.rpc;

import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.dto.GlobalExceptionLogDto;
import com.supos.cloud.provider.model.service.MdcExceptionLogFeignApi;
import com.supos.cloud.provider.service.MdcExceptionLogService;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The class Mdc product feign client.
 *
 * @author walkman
 */
@Slf4j
@RefreshScope
@RestController
@Api(value = "API - MdcExceptionLogFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcExceptionLogFeignClient extends BaseController implements MdcExceptionLogFeignApi {
	@Resource
	private MdcExceptionLogService mdcExceptionLogService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "保存日志并发送钉钉消息")
	public Wrapper saveAndSendExceptionLog(@RequestBody GlobalExceptionLogDto exceptionLogDto) {
		try {
			mdcExceptionLogService.saveAndSendExceptionLog(exceptionLogDto);
		} catch (Exception e) {
			log.error("saveAndSendExceptionLog={}", e.getMessage(), e);
		}
		return WrapMapper.ok();
	}
}
