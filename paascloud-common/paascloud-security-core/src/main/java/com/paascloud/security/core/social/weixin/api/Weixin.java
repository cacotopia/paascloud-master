package com.paascloud.security.core.social.weixin.api;

/**
 * 微信API调用接口
 *
 * @author walkman
 */
public interface Weixin {

	/**
	 * Gets user info.
	 *
	 * @param openId the open id
	 *
	 * @return the user info
	 */
	WeixinUserInfo getUserInfo(String openId);

}
