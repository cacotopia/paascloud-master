package com.supos.cloud.provider.model.service;


import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.MessageQueryDto;
import com.supos.cloud.base.dto.MqMessageVo;
import com.supos.cloud.provider.model.service.hystrix.MdcMqMessageApiHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The interface Mdc mq message feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcMqMessageApiHystrix.class)
public interface MdcMqMessageFeignApi {

    /**
     * Query waiting confirm message list wrapper.
     *
     * @param messageKeyList the message key list
     * @return the wrapper
     */
    @PostMapping(value = "/api/mdc/message/queryMessageKeyList")
    Wrapper<List<String>> queryMessageKeyList(@RequestParam("messageKeyList") List<String> messageKeyList);

    /**
     * Query message list with page wrapper.
     *
     * @param messageQueryDto the message query dto
     * @return the wrapper
     */
    @PostMapping(value = "/api/mdc/message/queryMessageListWithPage")
    Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(@RequestBody MessageQueryDto messageQueryDto);
}
