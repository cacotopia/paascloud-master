package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.AddressDTO;
import com.supos.cloud.provider.model.service.MdcAddressQueryFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Mdc product query feign hystrix.
 *
 * @author walkman
 */
@Component
public class MdcAddressQueryFeignHystrix implements MdcAddressQueryFeignApi {

    @Override
    public Wrapper<AddressDTO> getById(final Long addressId) {
        return null;
    }
}
