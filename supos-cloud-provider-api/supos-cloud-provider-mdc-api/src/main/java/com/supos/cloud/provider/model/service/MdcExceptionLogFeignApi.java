package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.dto.GlobalExceptionLogDto;
import com.supos.cloud.provider.model.service.hystrix.MdcExceptionLogFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Mdc product feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcExceptionLogFeignHystrix.class)
public interface MdcExceptionLogFeignApi {

    /**
     * Update product stock by id int.
     *
     * @param exceptionLogDto the exception log dto
     * @return the int
     */
    @PostMapping(value = "/api/exception/saveAndSendExceptionLog")
    Wrapper saveAndSendExceptionLog(@RequestBody GlobalExceptionLogDto exceptionLogDto);
}
