package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.vo.CartProductVo;
import com.supos.cloud.provider.model.service.OmcCartFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class Omc cart feign hystrix.
 *
 * @author walkman
 */
@Component
public class OmcCartFeignHystrix implements OmcCartFeignApi {
    @Override
    public Wrapper updateCartList(final List<CartProductVo> cartProductVoList) {
        return null;
    }

    @Override
    public Wrapper addProduct(final Long userId, final Long productId, final Integer count) {
        return null;
    }

    @Override
    public Wrapper updateProduct(final Long userId, final Long productId, final Integer count) {
        return null;
    }

    @Override
    public Wrapper deleteProduct(final Long userId, final String productIds) {
        return null;
    }

    @Override
    public Wrapper selectOrUnSelect(final Long userId, final Long productId, final Integer checked) {
        return null;
    }
}
