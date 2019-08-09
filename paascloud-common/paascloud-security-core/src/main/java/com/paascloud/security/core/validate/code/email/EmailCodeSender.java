package com.paascloud.security.core.validate.code.email;

/**
 * The interface Sms code sender.
 *
 * @author walkman
 */
public interface EmailCodeSender {

	/**
	 * Send.
	 *
	 * @param email the email
	 * @param code  the code
	 */
	void send(String email, String code);

}
