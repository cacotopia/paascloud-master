package com.supos.cloud.provider.model.service;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.annotation.NoNeedAccessAuthentication;
import com.supos.cloud.provider.model.dto.ProductCategoryDto;
import com.supos.cloud.provider.model.dto.ProductReqDto;
import com.supos.cloud.provider.model.service.hystrix.MdcProductCategoryQueryFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * The interface Mdc product category query feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductCategoryQueryFeignHystrix.class)
public interface MdcProductCategoryQueryFeignApi {

    /**
     * 查询分类信息.
     *
     * @param pid the pid
     * @return the product category data
     */
    @PostMapping(value = "/api/productCategory/getProductCategoryDtoByPid/{pid}")
    @NoNeedAccessAuthentication
    Wrapper<List<ProductCategoryDto>> getProductCategoryData(@PathVariable("pid") Long pid);

    /**
     * 查询商品列表.
     *
     * @param productReqDto the product req dto
     * @return the product list
     */
    @PostMapping(value = "/api/product/getProductList")
    @NoNeedAccessAuthentication
    Wrapper<PageInfo> getProductList(@RequestBody ProductReqDto productReqDto);

}
