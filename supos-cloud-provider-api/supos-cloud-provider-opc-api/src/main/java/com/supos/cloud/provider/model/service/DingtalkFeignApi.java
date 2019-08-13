package com.supos.cloud.provider.model.service;


import com.supos.cloud.annotation.NoNeedAccessAuthentication;
import com.supos.cloud.provider.model.dto.robot.ChatRobotMsgDto;
import com.supos.cloud.provider.model.service.hystrix.DingtalkFeignApiHystrix;
import com.supos.cloud.security.feign.OAuth2FeignAutoConfiguration;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Dingtalk feign api.
 *
 * @author walkman
 */
@FeignClient(value = "supos-cloud-provider-opc", configuration = OAuth2FeignAutoConfiguration.class, fallback = DingtalkFeignApiHystrix.class)
public interface DingtalkFeignApi {

	/**
	 * 钉钉机器人推送消息.
	 *
	 * @param uacUserReqDto the uac user req dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/opc/dingtalk/sendChatRobotMsg")
	@NoNeedAccessAuthentication
	Wrapper<Boolean> sendChatRobotMsg(@RequestBody ChatRobotMsgDto uacUserReqDto);
}
