package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.ProductDto;
import com.supos.cloud.provider.model.service.MdcProductFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Mdc product feign hystrix.
 *
 * @author walkman
 */
@Component
public class MdcProductFeignHystrix implements MdcProductFeignApi {

    @Override
    public Wrapper<Integer> updateProductStockById(final ProductDto productDto) {
        return null;
    }

    @Override
    public Wrapper<String> getMainImage(final Long productId) {
        return null;
    }
}
