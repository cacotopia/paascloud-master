package com.supos.cloud.provider.security;

import com.supos.cloud.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * The class Pc permission authorize config provider.
 *
 * @author walkman
 */
@Order
@Component
public class PcPermissionAuthorizeConfigProvider implements AuthorizeConfigProvider {

	/**
	 * Config boolean.
	 *
	 * @param config the config
	 *
	 * @return the boolean
	 */
	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		config
				.anyRequest()
				.access("@permissionService.hasPermission(authentication,request)");
		return true;
	}

}
