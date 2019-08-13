package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.GlobalExceptionLogDto;
import com.supos.cloud.provider.model.service.MdcExceptionLogFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;


/**
 * The class Mdc exception log feign hystrix.
 *
 * @author walkman
 */
@Component
public class MdcExceptionLogFeignHystrix implements MdcExceptionLogFeignApi {

    @Override
    public Wrapper saveAndSendExceptionLog(final GlobalExceptionLogDto exceptionLogDto) {
        return null;
    }
}
