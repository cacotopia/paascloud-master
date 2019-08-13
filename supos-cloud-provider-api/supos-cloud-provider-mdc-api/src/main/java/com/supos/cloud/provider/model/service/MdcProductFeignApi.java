package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.dto.ProductDto;
import com.supos.cloud.provider.model.service.hystrix.MdcProductFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Mdc product feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductFeignHystrix.class)
public interface MdcProductFeignApi {

    /**
     * Update product stock by id int.
     *
     * @param productDto the product dto
     * @return the int
     */
    @PostMapping(value = "/api/product/updateProductStockById")
    Wrapper<Integer> updateProductStockById(@RequestBody ProductDto productDto);

    /**
     * Gets main image.
     *
     * @param productId the product
     *                  id
     * @return the main image
     */
    @PostMapping(value = "/api/product/getMainImage")
    Wrapper<String> getMainImage(@RequestParam("productId") Long productId);
}
