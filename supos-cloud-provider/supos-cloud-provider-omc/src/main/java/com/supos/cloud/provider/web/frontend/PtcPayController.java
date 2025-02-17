package com.supos.cloud.provider.web.frontend;

//import com.alipay.demo.trade.config.Configs;

import com.google.common.collect.Maps;
import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.constant.PtcApiConstant;
import com.supos.cloud.provider.service.PtcAlipayService;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * The class Ptc pay controller.
 *
 * @author walkman
 */
@RestController
@RequestMapping(value = "/pay")
@Api(value = "WEB - PtcPayController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PtcPayController extends BaseController {
    
    @Resource
    private PtcAlipayService ptcAlipayService;

    /**
     * 生成付款二维码.
     *
     * @param orderNo the order no
     * @return the wrapper
     */
    @PostMapping("/createQrCodeImage/{orderNo}")
    @ApiOperation(httpMethod = "POST", value = "生成付款二维码")
    public Wrapper createQrCodeImage(@PathVariable String orderNo) {
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        return ptcAlipayService.pay(orderNo, loginAuthDto);
    }

    /**
     * 支付宝回调信息.
     *
     * @param request the request
     * @return the object
     */
    @PostMapping("/alipayCallback")
    @ApiOperation(httpMethod = "POST", value = "支付宝回调信息")
    public Object alipayCallback(HttpServletRequest request) {
        logger.info("收到支付宝回调信息");
        Map<String, String> params = Maps.newHashMap();

        Map requestParams = request.getParameterMap();
        for (Object o : requestParams.keySet()) {
            String name = (String) o;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {

                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        logger.info("支付宝回调,sign:{},trade_status:{},参数:{}", params.get("sign"), params.get("trade_status"), params.toString());

        //非常重要,验证回调的正确性,是不是支付宝发的.并且呢还要避免重复通知.

        params.remove("sign_type");
//		try {
//			boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, Configs.getAlipayPublicKey(), "utf-8", Configs.getSignType());
//
//			if (!alipayRSACheckedV2) {
//				return WrapMapper.error("非法请求,验证不通过,再恶意请求我就报警找网警了");
//			}
//		} catch (AlipayApiException e) {
//			logger.error("支付宝验证回调异常", e);
//		}

        //todo 验证各种数据
        Wrapper serverResponse = ptcAlipayService.aliPayCallback(params);
        if (serverResponse.success()) {
            return PtcApiConstant.AlipayCallback.RESPONSE_SUCCESS;
        }
        return PtcApiConstant.AlipayCallback.RESPONSE_FAILED;
    }

}
