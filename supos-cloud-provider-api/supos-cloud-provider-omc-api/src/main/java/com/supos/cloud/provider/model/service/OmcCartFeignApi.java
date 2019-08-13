package com.supos.cloud.provider.model.service;

import com.supos.cloud.provider.model.vo.CartProductVo;
import com.supos.cloud.provider.model.service.hystrix.OmcCartFeignHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The interface Omc cart feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcCartFeignHystrix.class)
public interface OmcCartFeignApi {
    /**
     * 更新购物车.
     *
     * @param cartProductVoList the cart product vo list
     * @return the wrapper
     */
    @PostMapping(value = "/api/cart/updateCartList")
    Wrapper updateCartList(@RequestBody List<CartProductVo> cartProductVoList);

    /**
     * 添加购物车.
     *
     * @param userId    the user id
     * @param productId the product id
     * @param count     the count
     * @return the wrapper
     */
    @PostMapping(value = "/api/cart/addProduct")
    Wrapper addProduct(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId, @RequestParam("count") Integer count);

    /**
     * 更新商品信息.
     *
     * @param userId    the user id
     * @param productId the product id
     * @param count     the count
     * @return the wrapper
     */
    @PostMapping(value = "/api/cart/updateProduct")
    Wrapper updateProduct(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId, @RequestParam("count") Integer count);

    /**
     * 删除商品信息.
     *
     * @param userId     the user id
     * @param productIds the product ids
     * @return the wrapper
     */
    @PostMapping(value = "/api/cart/deleteProduct")
    Wrapper deleteProduct(@RequestParam("userId") Long userId, @RequestParam("productIds") String productIds);

    /**
     * 选中和反选商品.
     *
     * @param userId    the user id
     * @param productId the product id
     * @param checked   the checked
     * @return the wrapper
     */
    @PostMapping(value = "/api/cart/selectOrUnSelect")
    Wrapper selectOrUnSelect(@RequestParam(name = "userId") Long userId, @RequestParam(name = "productId", required = false) Long productId, @RequestParam(name = "checked") Integer checked);
}

