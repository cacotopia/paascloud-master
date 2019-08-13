package com.supos.cloud.provider.service;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.MessageQueryDto;
import com.supos.cloud.base.dto.MqMessageVo;
import com.supos.cloud.base.enums.ErrorCodeEnum;
import com.supos.cloud.provider.model.exceptions.TpcBizException;
import com.supos.cloud.provider.model.service.UacMqMessageFeignApi;
import com.supos.cloud.provider.model.service.UacUserTokenFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Uac rpc service.
 *
 * @author walkman
 */
@Service
@Slf4j
public class UacRpcService {
	@Resource
	private UacUserTokenFeignApi uacUserTokenFeignApi;
	@Resource
	private UacMqMessageFeignApi uacMqMessageFeignApi;

	@Retryable(value = Exception.class, backoff = @Backoff(delay = 5000, multiplier = 2))
	public void batchUpdateTokenOffLine() {
		Wrapper<Integer> wrapper = uacUserTokenFeignApi.updateTokenOffLine();
		if (wrapper == null) {
			log.error("updateTokenOffLine 失败 result is null");
			return;
		}
		Integer result = wrapper.getResult();
		if (result == null || result == 0) {
			log.error("updateTokenOffLine 失败");
		} else {
			log.error("updateTokenOffLine 成功");
		}
	}

	public List<String> queryWaitingConfirmMessageKeyList(List<String> messageKeyList) {
		Wrapper<List<String>> wrapper = uacMqMessageFeignApi.queryMessageKeyList(messageKeyList);
		if (wrapper == null) {
			log.error("queryWaitingConfirmMessageKeyList 失败 result is null");
			throw new TpcBizException(ErrorCodeEnum.GL99990002);
		}
		return wrapper.getResult();
	}

	public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(MessageQueryDto messageQueryDto) {
		Wrapper<PageInfo<MqMessageVo>> wrapper = uacMqMessageFeignApi.queryMessageListWithPage(messageQueryDto);
		if (wrapper == null) {
			log.error("查询消息记录 失败 result is null");
			throw new TpcBizException(ErrorCodeEnum.GL99990002);
		}
		return wrapper;
	}

}