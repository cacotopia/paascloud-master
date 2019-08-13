package com.supos.cloud.provider.model.service.hystrix;


import com.supos.cloud.provider.model.service.UacUserTokenFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Uac user token feign api hystrix.
 *
 * @author walkman
 */
@Component
public class UacUserTokenFeignApiHystrix implements UacUserTokenFeignApi {

    @Override
    public Wrapper<Integer> updateTokenOffLine() {
        return null;
    }
}
