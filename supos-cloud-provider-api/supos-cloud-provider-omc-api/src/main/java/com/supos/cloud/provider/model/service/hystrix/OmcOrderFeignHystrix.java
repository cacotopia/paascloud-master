package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.OrderDto;
import com.supos.cloud.provider.model.service.OmcOrderFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Omc order feign hystrix.
 *
 * @author walkman
 */
@Component
public class OmcOrderFeignHystrix implements OmcOrderFeignApi {

	@Override
	public Wrapper updateOrderById(final OrderDto order) {
		return null;
	}
}
