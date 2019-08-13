package com.supos.cloud.provider.web.rpc;

import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.dto.OrderDto;
import com.supos.cloud.provider.model.service.OmcOrderQueryFeignApi;
import com.supos.cloud.provider.service.OmcOrderService;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The class Omc order query feign client.
 *
 * @author walkman
 */
@RefreshScope
@RestController
@Api(value = "API - OmcOrderQueryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmcOrderQueryFeignClient extends BaseController implements OmcOrderQueryFeignApi {
	@Resource
	private OmcOrderService omcOrderService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "根据订单号查询订单信息")
	public Wrapper<OrderDto> queryByOrderNo(@PathVariable("orderNo") String orderNo) {
		logger.info("selectByOrderNo - 根据订单号查询订单信息. orderNo={}", orderNo);
		OrderDto orderDto = omcOrderService.queryOrderDtoByOrderNo(orderNo);
		return WrapMapper.ok(orderDto);
	}

	@Override
	@ApiOperation(httpMethod = "POST", value = "根据订单号查询用户订单信息")
	public Wrapper<OrderDto> queryByUserIdAndOrderNo(@PathVariable("userId") Long userId, @PathVariable("orderNo") String orderNo) {
		logger.info("selectByUserIdAndOrderNo - 根据订单号查询用户订单信息. userId={}, orderNo={}", userId, orderNo);
		OrderDto orderDto = omcOrderService.queryOrderDtoByUserIdAndOrderNo(userId, orderNo);
		return WrapMapper.ok(orderDto);
	}
}
