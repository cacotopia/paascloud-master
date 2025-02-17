package com.supos.cloud.provider.web.rpc;

import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.vo.CartProductVo;
import com.supos.cloud.provider.model.service.OmcCartFeignApi;
import com.supos.cloud.provider.service.OmcCartService;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Mall cart feign client.
 *
 * @author walkman
 */
@RefreshScope
@RestController
@Api(value = "API - MallCartFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MallCartFeignClient extends BaseController implements OmcCartFeignApi {

	@Resource
	private OmcCartService omcCartService;

	@Override
	@ApiOperation(httpMethod = "POST", value = "更新购物车")
	public Wrapper updateCartList(@RequestBody List<CartProductVo> cartProductVoList) {
		logger.info("updateCartList - 更新购物车. cartProductVoList={}", cartProductVoList);
		int result = omcCartService.updateCartList(cartProductVoList);
		return handleResult(result);
	}

	@Override
	@ApiOperation(httpMethod = "POST", value = "保存购物车信息")
	public Wrapper addProduct(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId, @RequestParam(value = "count") Integer count) {
		logger.info("updateCartList - 保存购物车信息. productId={}, count={}", productId, count);
		int result = omcCartService.saveCart(userId, productId, count);
		return handleResult(result);
	}

	@Override
	@ApiOperation(httpMethod = "POST", value = "更新购物车信息")
	public Wrapper updateProduct(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
		logger.info("updateProduct - 更新购物车信息. productId={}, count={}", productId, count);
		int result = omcCartService.updateCart(userId, productId, count);
		return handleResult(result);
	}

	@Override
	@ApiOperation(httpMethod = "POST", value = "删除购物车商品信息")
	public Wrapper deleteProduct(@RequestParam("userId") Long userId, @RequestParam("productIds") String productIds) {
		logger.info("deleteProduct - 删除购物车商品信息. productIds={}, userId={}", productIds, userId);
		int result = omcCartService.deleteProduct(userId, productIds);
		return handleResult(result);
	}

	@Override
	@ApiOperation(httpMethod = "POST", value = "选中或者反选商品信息")
	public Wrapper selectOrUnSelect(@RequestParam(name = "userId") Long userId, @RequestParam(name = "productId", required = false) Long productId, @RequestParam(name = "checked") Integer checked) {
		logger.info("selectOrUnSelect - 选中或者反选商品信息. productId={}, userId={}, checked={}", productId, userId, checked);
		int result = omcCartService.selectOrUnSelect(userId, productId, checked);
		return handleResult(result);
	}
}
