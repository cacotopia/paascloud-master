package com.supos.cloud.provider.service;

import com.supos.cloud.provider.model.dto.sms.SmsMessage;

import javax.servlet.http.HttpServletResponse;


/**
 * The interface Sms service.
 *
 * @author walkman
 */
public interface SmsService {
	/**
	 * Send sms code.
	 *
	 * @param smsMessage the sms message
	 * @param ipAddr     the ip addr
	 */
	void sendSmsCode(SmsMessage smsMessage, String ipAddr);

	/**
	 * Submit reset pwd phone.
	 *
	 * @param mobile   the mobile
	 * @param response the response
	 *
	 * @return the string
	 */
	String submitResetPwdPhone(String mobile, HttpServletResponse response);
}
