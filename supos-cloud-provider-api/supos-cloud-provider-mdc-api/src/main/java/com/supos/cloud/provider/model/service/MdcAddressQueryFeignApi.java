package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.dto.AddressDTO;
import com.supos.cloud.provider.model.service.hystrix.MdcAddressQueryFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Mdc product query feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcAddressQueryFeignHystrix.class)
public interface MdcAddressQueryFeignApi {

    /**
     * Select by id wrapper.
     *
     * @param addressId the address id
     * @return the wrapper
     */
    @PostMapping(value = "/api/address/getById/{addressId}")
    Wrapper<AddressDTO> getById(@PathVariable("addressId") Long addressId);
}
