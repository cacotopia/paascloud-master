package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.service.hystrix.OmcOrderDetailFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * The interface Omc order detail feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderDetailFeignHystrix.class)
public interface OmcOrderDetailFeignApi {
}
