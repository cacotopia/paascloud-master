package com.supos.cloud.provider.service;


import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.MessageQueryDto;
import com.supos.cloud.base.dto.MqMessageVo;
import com.supos.cloud.base.enums.ErrorCodeEnum;
import com.supos.cloud.provider.model.exceptions.TpcBizException;
import com.supos.cloud.provider.model.service.MdcMqMessageFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The class Mdc rpc service.
 *
 * @author walkman
 */
@Slf4j
@Service
public class MdcRpcService {
	@Resource
	private MdcMqMessageFeignApi mdcMqMessageFeignApi;

	public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(final MessageQueryDto messageQueryDto) {
		Wrapper<PageInfo<MqMessageVo>> wrapper = mdcMqMessageFeignApi.queryMessageListWithPage(messageQueryDto);
		if (wrapper == null) {
			log.error("查询消息记录. 失败 result is null");
			throw new TpcBizException(ErrorCodeEnum.GL99990002);
		}
		return wrapper;
	}
}