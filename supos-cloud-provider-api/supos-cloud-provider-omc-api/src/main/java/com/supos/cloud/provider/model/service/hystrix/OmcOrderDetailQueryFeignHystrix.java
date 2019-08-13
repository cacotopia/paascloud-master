package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.OrderDetailDto;
import com.supos.cloud.provider.model.service.OmcOrderDetailQueryFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class Omc order detail query feign hystrix.
 *
 * @author walkman
 */
@Component
public class OmcOrderDetailQueryFeignHystrix implements OmcOrderDetailQueryFeignApi {

	@Override
	public Wrapper<List<OrderDetailDto>> getListByOrderNoUserId(final String orderNo, final Long userId) {
		return null;
	}
}
