package com.supos.cloud.provider.model.service.hystrix;


import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.MessageQueryDto;
import com.supos.cloud.base.dto.MqMessageVo;
import com.supos.cloud.provider.model.service.OpcMqMessageFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class Opc mq message feign api hystrix.
 *
 * @author walkman
 */
@Component
public class OpcMqMessageFeignApiHystrix implements OpcMqMessageFeignApi {

	@Override
	public Wrapper<List<String>> queryMessageKeyList(final List<String> messageKeyList) {
		return null;
	}

	@Override
	public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(final MessageQueryDto messageQueryDto) {
		return null;
	}
}
