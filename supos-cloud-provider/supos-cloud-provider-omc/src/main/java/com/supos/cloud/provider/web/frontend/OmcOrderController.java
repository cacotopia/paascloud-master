package com.supos.cloud.provider.web.frontend;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.BaseQuery;
import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.dto.OrderPageQuery;
import com.supos.cloud.provider.model.vo.OrderProductVo;
import com.supos.cloud.provider.model.vo.OrderVo;
import com.supos.cloud.provider.service.OmcCartService;
import com.supos.cloud.provider.service.OmcOrderService;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * The class Omc order controller.
 *
 * @author walkman
 */
@RestController
@RequestMapping(value = "/order")
@Api(value = "WEB - OmcOrderController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmcOrderController extends BaseController {

    @Resource
    private OmcOrderService omcOrderService;

    @Resource
    private OmcCartService omcCartService;

    /**
     * 获取购物车数量.
     *
     * @return the cart count
     */
    @PostMapping(value = "getCartCount")
    public Wrapper<Integer> getCartCount() {
        return WrapMapper.ok(0);
    }

    /**
     * 获取购物车商品数量.
     *
     * @return the order cart product
     */
    @PostMapping("/getOrderCartProduct")
    @ApiOperation(httpMethod = "POST", value = "获取购物车商品数量")
    public Wrapper getOrderCartProduct() {
        logger.info("getOrderCartProduct - 获取购物车商品数量");
        OrderProductVo orderCartProduct = omcCartService.getOrderCartProduct(getLoginAuthDto().getUserId());
        return WrapMapper.ok(orderCartProduct);
    }

    /**
     * 创建订单.
     *
     * @param shippingId the shipping id
     * @return the wrapper
     */
    @PostMapping("createOrderDoc/{shippingId}")
    @ApiOperation(httpMethod = "POST", value = "创建订单")
    public Wrapper createOrderDoc(@PathVariable Long shippingId) {
        logger.info("createOrderDoc - 创建订单. shippingId={}", shippingId);
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        logger.info("操作人信息. loginAuthDto={}", loginAuthDto);

        OrderVo orderDoc = omcOrderService.createOrderDoc(loginAuthDto, shippingId);
        return WrapMapper.ok(orderDoc);
    }

    /**
     * 取消订单.
     *
     * @param orderNo the order no
     * @return the wrapper
     */
    @PostMapping("cancelOrderDoc/{orderNo}")
    @ApiOperation(httpMethod = "POST", value = "取消订单")
    public Wrapper cancelOrderDoc(@PathVariable String orderNo) {
        logger.info("cancelOrderDoc - 取消订单. orderNo={}", orderNo);
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        logger.info("操作人信息. loginAuthDto={}", loginAuthDto);

        int result = omcOrderService.cancelOrderDoc(loginAuthDto, orderNo);
        return handleResult(result);
    }

    /**
     * 查询订单详情.
     *
     * @param orderNo the order no
     * @return the wrapper
     */
    @PostMapping("queryUserOrderDetailList/{orderNo}")
    @ApiOperation(httpMethod = "POST", value = "查询订单详情")
    public Wrapper queryUserOrderDetailList(@PathVariable String orderNo) {
        logger.info("queryUserOrderDetailList - 查询用户订单明细. orderNo={}", orderNo);

        Long userId = getLoginAuthDto().getUserId();
        logger.info("操作人信息. userId={}", userId);

        OrderVo orderVo = omcOrderService.getOrderDetail(userId, orderNo);
        return WrapMapper.ok(orderVo);
    }

    @PostMapping("queryUserOrderDetail/{orderNo}")
    @ApiOperation(httpMethod = "POST", value = "查询订单详情")
    public Wrapper queryUserOrderDetail(@PathVariable String orderNo) {
        logger.info("queryUserOrderDetail - 查询订单明细. orderNo={}", orderNo);

        OrderVo orderVo = omcOrderService.getOrderDetail(orderNo);
        return WrapMapper.ok(orderVo);
    }

    /**
     * Query user order list with page wrapper.
     *
     * @param baseQuery the base query
     * @return the wrapper
     */
    @PostMapping("queryUserOrderListWithPage")
    @ApiOperation(httpMethod = "POST", value = "查询用户订单列表")
    public Wrapper queryUserOrderListWithPage(@RequestBody BaseQuery baseQuery) {
        logger.info("queryUserOrderListWithPage - 查询用户订单集合. baseQuery={}", baseQuery);

        Long userId = getLoginAuthDto().getUserId();
        logger.info("操作人信息. userId={}", userId);

        PageInfo pageInfo = omcOrderService.queryUserOrderListWithPage(userId, baseQuery);
        return WrapMapper.ok(pageInfo);
    }

    @PostMapping("queryOrderListWithPage")
    @ApiOperation(httpMethod = "POST", value = "查询用户订单列表")
    public Wrapper queryOrderListWithPage(@RequestBody OrderPageQuery orderPageQuery) {
        logger.info("queryOrderListWithPage - 查询订单集合. orderPageQuery={}", orderPageQuery);
        PageInfo pageInfo = omcOrderService.queryOrderListWithPage(orderPageQuery);
        return WrapMapper.ok(pageInfo);
    }

    /**
     * 查询订单状态.
     *
     * @param orderNo the order no
     * @return the wrapper
     */
    @PostMapping("queryOrderPayStatus/{orderNo}")
    @ApiOperation(httpMethod = "POST", value = "查询订单状态")
    public Wrapper<Boolean> queryOrderPayStatus(@PathVariable String orderNo) {
        logger.info("queryOrderPayStatus - 查询订单状态. orderNo={}", orderNo);
        boolean result = omcOrderService.queryOrderPayStatus(getLoginAuthDto().getUserId(), orderNo);
        return WrapMapper.ok(result);
    }

}
