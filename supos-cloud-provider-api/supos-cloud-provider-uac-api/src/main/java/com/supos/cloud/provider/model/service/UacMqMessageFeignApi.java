package com.supos.cloud.provider.model.service;


import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.MessageQueryDto;
import com.supos.cloud.base.dto.MqMessageVo;
import com.supos.cloud.provider.model.service.hystrix.UacMqMessageApiHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The interface Uac user token feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-uac", configuration = OAuth2FeignAutoConfiguration.class, fallback = UacMqMessageApiHystrix.class)
public interface UacMqMessageFeignApi {

    /**
     * Query waiting confirm message list wrapper.
     *
     * @param messageKeyList the message key list
     * @return the wrapper
     */
    @PostMapping(value = "/api/uac/message/queryMessageKeyList")
    Wrapper<List<String>> queryMessageKeyList(@RequestParam("messageKeyList") List<String> messageKeyList);

    /**
     * Query message list with page wrapper.
     *
     * @param messageQueryDto the message query dto
     * @return the wrapper
     */
    @PostMapping(value = "/api/uac/message/queryMessageListWithPage")
    Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(@RequestBody MessageQueryDto messageQueryDto);
}
