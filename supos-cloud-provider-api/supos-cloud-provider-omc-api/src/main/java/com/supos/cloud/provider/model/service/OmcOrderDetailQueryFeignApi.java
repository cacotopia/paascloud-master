package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.dto.OrderDetailDto;
import com.supos.cloud.provider.model.service.hystrix.OmcOrderDetailQueryFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * The interface Omc order detail query feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderDetailQueryFeignHystrix.class)
public interface OmcOrderDetailQueryFeignApi {
	/**
	 * Gets list by order no user id.
	 *
	 * @param orderNo the order no
	 * @param userId  the user id
	 *
	 * @return the list by order no user id
	 */
	@PostMapping(value = "/api/orderDetail/getListByOrderNoUserId/{userId}/{orderNo}")
	Wrapper<List<OrderDetailDto>> getListByOrderNoUserId(@PathVariable("orderNo") String orderNo, @PathVariable("userId") Long userId);
}
