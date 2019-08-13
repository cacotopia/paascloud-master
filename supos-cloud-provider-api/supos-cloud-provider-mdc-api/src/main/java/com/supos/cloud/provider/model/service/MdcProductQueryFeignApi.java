package com.supos.cloud.provider.model.service;

import com.supos.cloud.annotation.NoNeedAccessAuthentication;
import com.supos.cloud.provider.model.dto.ProductDto;
import com.supos.cloud.provider.model.vo.ProductDetailVo;
import com.supos.cloud.provider.model.service.hystrix.MdcProductQueryFeignHystrix;
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
@FeignClient(value = "supos-cloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductQueryFeignHystrix.class)
public interface MdcProductQueryFeignApi {

    /**
     * 查询商品详情信息.
     *
     * @param productId the product id
     * @return the product detail
     */
    @PostMapping(value = "/api/product/getProductDetail/{productId}")
    @NoNeedAccessAuthentication
    Wrapper<ProductDetailVo> getProductDetail(@PathVariable("productId") Long productId);

    /**
     * Select by id wrapper.
     *
     * @param productId the product id
     * @return the wrapper
     */
    @PostMapping(value = "/api/product/selectById/{productId}")
    @NoNeedAccessAuthentication
    Wrapper<ProductDto> selectById(@PathVariable("productId") Long productId);
}
