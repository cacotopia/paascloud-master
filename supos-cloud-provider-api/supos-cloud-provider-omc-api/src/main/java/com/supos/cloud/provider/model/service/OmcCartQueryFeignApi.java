package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.vo.CartVo;
import com.supos.cloud.provider.model.service.hystrix.OmcCartQueryFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Omc cart query feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcCartQueryFeignHystrix.class)
public interface OmcCartQueryFeignApi {

	/**
	 * Gets cart vo.
	 *
	 * @param userId the user id
	 *
	 * @return the cart vo
	 */
	@PostMapping(value = "/api/cart/getCarVo")
	Wrapper<CartVo> getCartVo(@RequestParam("userId") Long userId);
}
