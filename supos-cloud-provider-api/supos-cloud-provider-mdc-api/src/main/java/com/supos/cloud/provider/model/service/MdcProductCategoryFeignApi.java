package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.service.hystrix.MdcProductCategoryFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * The interface Mdc product category feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductCategoryFeignHystrix.class)
public interface MdcProductCategoryFeignApi {

}
