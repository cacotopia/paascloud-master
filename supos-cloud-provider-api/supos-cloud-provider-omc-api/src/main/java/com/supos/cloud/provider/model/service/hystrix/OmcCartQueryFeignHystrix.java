package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.vo.CartVo;
import com.supos.cloud.provider.model.service.OmcCartQueryFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Omc cart query feign hystrix.
 *
 * @author walkman
 */
@Component
public class OmcCartQueryFeignHystrix implements OmcCartQueryFeignApi {

	@Override
	public Wrapper<CartVo> getCartVo(final Long userId) {
		return null;
	}
}
