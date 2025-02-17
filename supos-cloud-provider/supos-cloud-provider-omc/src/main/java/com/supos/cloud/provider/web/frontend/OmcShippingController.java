package com.supos.cloud.provider.web.frontend;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.domain.OmcShipping;
import com.supos.cloud.provider.service.OmcShippingService;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * The class Omc shipping controller.
 *
 * @author walkman
 */
@RestController
@RequestMapping(value = "/shipping", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - OmcShippingController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmcShippingController extends BaseController {

    @Resource
    private OmcShippingService omcShippingService;

    /**
     * 增加收货人地址.
     *
     * @param shipping the shipping
     * @return the wrapper
     */
    @PostMapping("/addShipping")
    @ApiOperation(httpMethod = "POST", value = "增加收货人地址")
    public Wrapper addShipping(OmcShipping shipping) {

        logger.info("addShipping - 增加收货人地址. shipping={}", shipping);
        int result = omcShippingService.saveShipping(getLoginAuthDto(), shipping);
        return handleResult(result);

    }

    /**
     * 删除收货人地址.
     *
     * @param shippingId the shipping id
     * @return the wrapper
     */
    @PostMapping("/deleteShipping/{shippingId}")
    @ApiOperation(httpMethod = "POST", value = "删除收货人地址")
    public Wrapper deleteShipping(@PathVariable Integer shippingId) {
        Long userId = getLoginAuthDto().getUserId();
        logger.info("deleteShipping - 删除收货人地址. userId={}, shippingId={}", userId, shippingId);
        int result = omcShippingService.deleteShipping(userId, shippingId);
        return handleResult(result);
    }

    /**
     * 编辑收货人地址.
     *
     * @param shipping the shipping
     * @return the wrapper
     */
    @PostMapping("/updateShipping")
    @ApiOperation(httpMethod = "POST", value = "编辑收货人地址")
    public Wrapper updateShipping(OmcShipping shipping) {
        logger.info("updateShipping - 编辑收货人地址. shipping={}", shipping);
        int result = omcShippingService.saveShipping(getLoginAuthDto(), shipping);
        return handleResult(result);
    }

    /**
     * 设置默认收货地址.
     *
     * @param addressId the address id
     * @return the default address
     */
    @PostMapping("/setDefaultAddress/{addressId}")
    @ApiOperation(httpMethod = "POST", value = "设置默认收货地址")
    public Wrapper setDefaultAddress(@PathVariable Long addressId) {
        logger.info("updateShipping - 设置默认地址. addressId={}", addressId);
        int result = omcShippingService.setDefaultAddress(getLoginAuthDto(), addressId);
        return handleResult(result);
    }

    /**
     * 根据Id查询收货人地址.
     *
     * @param shippingId the shipping id
     * @return the wrapper
     */
    @PostMapping("/selectShippingById/{shippingId}")
    @ApiOperation(httpMethod = "POST", value = "根据Id查询收货人地址")
    public Wrapper<OmcShipping> selectShippingById(@PathVariable Long shippingId) {
        Long userId = getLoginAuthDto().getUserId();
        logger.info("selectShippingById - 根据Id查询收货人地址. userId={}, shippingId={}", userId, shippingId);
        OmcShipping omcShipping = omcShippingService.selectByShippingIdUserId(userId, shippingId);
        return WrapMapper.ok(omcShipping);
    }

    /**
     * 分页查询当前用户收货人地址列表.
     *
     * @param shipping the shipping
     * @return the wrapper
     */
    @PostMapping("queryUserShippingListWithPage")
    @ApiOperation(httpMethod = "POST", value = "分页查询当前用户收货人地址列表")
    public Wrapper<PageInfo> queryUserShippingListWithPage(@RequestBody OmcShipping shipping) {
        Long userId = getLoginAuthDto().getUserId();
        logger.info("queryUserShippingListWithPage - 分页查询当前用户收货人地址列表.userId={} shipping={}", userId, shipping);
        PageInfo pageInfo = omcShippingService.queryListWithPageByUserId(userId, shipping.getPageNum(), shipping.getPageSize());
        return WrapMapper.ok(pageInfo);
    }

    /**
     * 分页查询收货人地址列表.
     *
     * @param shipping the shipping
     * @return the wrapper
     */
    @PostMapping("queryShippingListWithPage")
    @ApiOperation(httpMethod = "POST", value = "分页查询收货人地址列表")
    public Wrapper<PageInfo> queryShippingListWithPage(@RequestBody OmcShipping shipping) {
        logger.info("queryShippingListWithPage - 分页查询收货人地址列表. shipping={}", shipping);
        PageInfo pageInfo = omcShippingService.queryShippingListWithPage(shipping);
        return WrapMapper.ok(pageInfo);
    }

}
