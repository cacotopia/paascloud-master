package com.supos.cloud.security.core.social.weixin.connect;

import com.supos.cloud.security.core.social.weixin.api.WeixinUserInfo;
import com.supos.cloud.security.core.social.weixin.api.Weixin;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * 微信 api适配器，将微信 api的数据模型转为spring social的标准模型。
 *
 * @author walkman
 */
public class WeixinAdapter implements ApiAdapter<Weixin> {

	private String openId;

	/**
	 * Instantiates a new Weixin adapter.
	 */
	WeixinAdapter() {
	}

	/**
	 * Instantiates a new Weixin adapter.
	 *
	 * @param openId the open id
	 */
	WeixinAdapter(String openId) {
		this.openId = openId;
	}

	/**
	 * Test boolean.
	 *
	 * @param api the api
	 *
	 * @return boolean boolean
	 */
	@Override
	public boolean test(Weixin api) {
		return true;
	}

	/**
	 * Sets connection values.
	 *
	 * @param api    the api
	 * @param values the values
	 */
	@Override
	public void setConnectionValues(Weixin api, ConnectionValues values) {
		WeixinUserInfo profile = api.getUserInfo(openId);
		values.setProviderUserId(profile.getOpenid());
		values.setDisplayName(profile.getNickname());
		values.setImageUrl(profile.getHeadimgurl());
	}

	/**
	 * Fetch user profile user profile.
	 *
	 * @param api the api
	 *
	 * @return user profile
	 */
	@Override
	public UserProfile fetchUserProfile(Weixin api) {
		return null;
	}

	/**
	 * Update status.
	 *
	 * @param api     the api
	 * @param message the message
	 */
	@Override
	public void updateStatus(Weixin api, String message) {
		//do nothing
	}

}
