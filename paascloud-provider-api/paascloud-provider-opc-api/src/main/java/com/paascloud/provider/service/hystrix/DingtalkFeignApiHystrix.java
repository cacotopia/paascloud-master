package com.paascloud.provider.service.hystrix;


import com.paascloud.provider.model.dto.robot.ChatRobotMsgDto;
import com.paascloud.provider.service.DingtalkFeignApi;
import com.paascloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;


/**
 * The class Chat robot feign api hystrix.
 *
 * @author walkman
 */
@Component
public class DingtalkFeignApiHystrix implements DingtalkFeignApi {

	@Override
	public Wrapper<Boolean> sendChatRobotMsg(final ChatRobotMsgDto uacUserReqDto) {
		return null;
	}
}
