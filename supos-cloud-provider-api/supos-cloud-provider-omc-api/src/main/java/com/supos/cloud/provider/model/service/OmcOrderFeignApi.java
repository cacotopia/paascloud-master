package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.dto.OrderDto;
import com.supos.cloud.provider.model.service.hystrix.OmcOrderFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Omc order feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderFeignHystrix.class)
public interface OmcOrderFeignApi {
    /**
     * Update order by id wrapper.
     *
     * @param order the order
     * @return the wrapper
     */
    @PostMapping(value = "/api/order/updateOrderById")
    Wrapper updateOrderById(@RequestBody OrderDto order);
}
