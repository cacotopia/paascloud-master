package com.supos.cloud.provider.service;


import com.supos.cloud.provider.model.dto.user.LoginRespDto;

/**
 * The interface Uac login service.
 *
 * @author walkman
 */
public interface UacLoginService {

	/**
	 * Login after login resp dto.
	 *
	 * @param applicationId the application id
	 *
	 * @return the login resp dto
	 */
	LoginRespDto loginAfter(Long applicationId);

}
