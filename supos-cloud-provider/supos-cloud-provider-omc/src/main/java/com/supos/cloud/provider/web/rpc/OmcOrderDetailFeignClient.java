package com.supos.cloud.provider.web.rpc;

import com.supos.cloud.provider.model.service.OmcOrderDetailFeignApi;
import com.supos.cloud.core.support.BaseController;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * The class Omc order detail feign client.
 *
 * @author walkman
 */
@RefreshScope
@RestController
@Api(value = "API - OmcOrderDetailFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmcOrderDetailFeignClient extends BaseController implements OmcOrderDetailFeignApi {

}
