package com.supos.cloud.provider.model.service.hystrix;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.provider.model.dto.ProductCategoryDto;
import com.supos.cloud.provider.model.dto.ProductReqDto;
import com.supos.cloud.provider.model.service.MdcProductCategoryQueryFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class Mdc product category query feign hystrix.
 *
 * @author walkman
 */
@Component
public class MdcProductCategoryQueryFeignHystrix implements MdcProductCategoryQueryFeignApi {

    @Override
    public Wrapper<List<ProductCategoryDto>> getProductCategoryData(final Long pid) {
        return null;
    }

    @Override
    public Wrapper<PageInfo> getProductList(final ProductReqDto productReqDto) {
        return null;
    }
}
