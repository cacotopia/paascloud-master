package com.supos.cloud.provider.model.service.hystrix;


import com.supos.cloud.provider.model.dto.robot.ChatRobotMsgDto;
import com.supos.cloud.provider.model.service.DingtalkFeignApi;
import com.supos.cloud.wrapper.Wrapper;
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
