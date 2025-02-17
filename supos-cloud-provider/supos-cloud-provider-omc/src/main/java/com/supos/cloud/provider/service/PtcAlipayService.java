package com.supos.cloud.provider.service;

import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.wrapper.Wrapper;

import java.util.Map;

/**
 * The interface Ptc alipay service.
 *
 * @author walkman
 */
public interface PtcAlipayService {

	/**
	 * 生成付款二维码.
	 *
	 * @param orderNo      the order no
	 * @param loginAuthDto the login auth dto
	 *
	 * @return the wrapper
	 */
	Wrapper pay(String orderNo, LoginAuthDto loginAuthDto);

	/**
	 * Ali pay callback wrapper.
	 *
	 * @param params the params
	 *
	 * @return the wrapper
	 */
	Wrapper aliPayCallback(Map<String, String> params);
}
