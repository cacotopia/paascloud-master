package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.OrderDto;
import com.supos.cloud.provider.model.service.OmcOrderQueryFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Omc order query feign hystrix.
 *
 * @author walkman
 */
@Component
public class OmcOrderQueryFeignHystrix implements OmcOrderQueryFeignApi {


	@Override
	public Wrapper<OrderDto> queryByOrderNo(final String orderNo) {
		return null;
	}

	@Override
	public Wrapper<OrderDto> queryByUserIdAndOrderNo(final Long userId, final String orderNo) {
		return null;
	}
}
