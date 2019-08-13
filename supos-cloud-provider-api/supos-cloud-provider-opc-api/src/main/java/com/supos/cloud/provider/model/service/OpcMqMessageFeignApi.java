package com.supos.cloud.provider.model.service;


import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.MessageQueryDto;
import com.supos.cloud.base.dto.MqMessageVo;
import com.supos.cloud.provider.model.service.hystrix.OpcMqMessageFeignApiHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * The interface Opc mq message feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-opc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OpcMqMessageFeignApiHystrix.class)
public interface OpcMqMessageFeignApi {

	/**
	 * Query waiting confirm message list wrapper.
	 *
	 * @param messageKeyList the message key list
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/opc/message/queryMessageKeyList")
	Wrapper<List<String>> queryMessageKeyList(@RequestParam("messageKeyList") List<String> messageKeyList);

	/**
	 * Query message list with page wrapper.
	 *
	 * @param messageQueryDto the message query dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/opc/message/queryMessageListWithPage")
	Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(@RequestBody MessageQueryDto messageQueryDto);
}
