package com.supos.cloud.provider.web.rpc;

import com.google.common.collect.Lists;
import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.domain.OmcOrderDetail;
import com.supos.cloud.provider.model.dto.OrderDetailDto;
import com.supos.cloud.provider.model.service.OmcOrderDetailQueryFeignApi;
import com.supos.cloud.provider.service.OmcOrderDetailService;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Omc order detail query feign client.
 *
 * @author walkman
 */
@RefreshScope
@RestController
@Api(value = "API - MallCartQueryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmcOrderDetailQueryFeignClient extends BaseController implements OmcOrderDetailQueryFeignApi {
	@Resource
	private OmcOrderDetailService omcOrderDetailService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "获取用户订单详情")
	public Wrapper<List<OrderDetailDto>> getListByOrderNoUserId(@PathVariable("orderNo") String orderNo, @PathVariable("userId") Long userId) {
		logger.info("getListByOrderNoUserId - 获取用户订单详情. orderNo={}, userId={}", orderNo, userId);
		List<OmcOrderDetail> list = omcOrderDetailService.getListByOrderNoUserId(orderNo, userId);

		List<OrderDetailDto> orderDetailDtoList = Lists.newArrayList();

		for (OmcOrderDetail orderDetail : list) {

			OrderDetailDto orderDetailDto = new OrderDetailDto();
			BeanUtils.copyProperties(orderDetail, orderDetailDto);
			orderDetailDtoList.add(orderDetailDto);
		}

		return WrapMapper.ok(orderDetailDtoList);
	}
}
