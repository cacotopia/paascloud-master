package com.supos.cloud.provider.model.service;


import com.supos.cloud.provider.model.service.hystrix.UacUserTokenFeignApiHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Uac user token feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-uac", configuration = OAuth2FeignAutoConfiguration.class, fallback = UacUserTokenFeignApiHystrix.class)
public interface UacUserTokenFeignApi {

    /**
     * 超时token更新为离线.
     *
     * @return the wrapper
     */
    @PostMapping(value = "/api/uac/token/updateTokenOffLine")
    Wrapper<Integer> updateTokenOffLine();
}
