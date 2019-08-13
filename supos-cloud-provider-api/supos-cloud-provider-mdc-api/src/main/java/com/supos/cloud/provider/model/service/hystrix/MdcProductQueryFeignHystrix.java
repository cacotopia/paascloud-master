package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.ProductDto;
import com.supos.cloud.provider.model.service.MdcProductQueryFeignApi;
import com.supos.cloud.provider.model.vo.ProductDetailVo;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Mdc product query feign hystrix.
 *
 * @author walkman
 */
@Component
public class MdcProductQueryFeignHystrix implements MdcProductQueryFeignApi {

    @Override
    public Wrapper<ProductDetailVo> getProductDetail(final Long productId) {
        return null;
    }

    @Override
    public Wrapper<ProductDto> selectById(final Long productId) {
        return null;
    }
}
