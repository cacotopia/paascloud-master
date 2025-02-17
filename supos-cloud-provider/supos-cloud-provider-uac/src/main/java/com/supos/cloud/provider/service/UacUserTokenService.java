package com.supos.cloud.provider.service;

import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.base.dto.UserTokenDto;
import com.supos.cloud.core.support.IService;
import com.supos.cloud.provider.model.domain.UacUserToken;
import com.supos.cloud.provider.model.dto.token.TokenMainQueryDto;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录jwt token 管理.
 *
 * @author walkman
 */
public interface UacUserTokenService extends IService<UacUserToken> {
	/**
	 * 保存token.
	 *
	 * @param accessToken  the access token
	 * @param refreshToken the refresh token
	 * @param loginAuthDto the login auth dto
	 * @param request      the request
	 */
	void saveUserToken(String accessToken, String refreshToken, LoginAuthDto loginAuthDto, HttpServletRequest request);

	/**
	 * 获取token.
	 *
	 * @param accessToken the access token
	 *
	 * @return the by access token
	 */
	UserTokenDto getByAccessToken(String accessToken);


	/**
	 * 更新token.
	 *
	 * @param tokenDto     the token dto
	 * @param loginAuthDto the login auth dto
	 */
	void updateUacUserToken(UserTokenDto tokenDto, LoginAuthDto loginAuthDto);

	/**
	 * 分页查询token列表.
	 *
	 * @param token the token
	 *
	 * @return the page info
	 */
	PageInfo listTokenWithPage(TokenMainQueryDto token);

	/**
	 * 刷新token.
	 *
	 * @param accessToken  the access token
	 * @param refreshToken the refresh token
	 * @param request      the request
	 *
	 * @return the string
	 *
	 * @throws HttpProcessException the http process exception
	 */
	String refreshToken(String accessToken, String refreshToken, HttpServletRequest request) throws HttpProcessException;

	/**
	 * 更新token离线状态.
	 *
	 * @return the int
	 */
	int batchUpdateTokenOffLine();

}
