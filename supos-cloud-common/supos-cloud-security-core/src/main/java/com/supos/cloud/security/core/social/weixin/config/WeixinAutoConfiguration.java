package com.supos.cloud.security.core.social.weixin.config;

import com.supos.cloud.security.core.social.weixin.connect.WeixinConnectionFactory;
import com.supos.cloud.security.core.social.view.PcConnectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

import com.supos.cloud.security.core.properties.SecurityProperties;
import com.supos.cloud.security.core.properties.WeixinProperties;

/**
 * 微信登录配置
 *
 * @author walkman
 */
//@Configuration
//@ConditionalOnProperty(prefix = "paascloud.security.social.weixin", name = "app-id")
//public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {
//
//	@Autowired
//	private SecurityProperties securityProperties;
//
//	/**
//	 * Create connection factory connection factory.
//	 *
//	 * @return the connection factory
//	 */
//	@Override
//	protected ConnectionFactory<?> createConnectionFactory() {
//		WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
//		return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
//				weixinConfig.getAppSecret());
//	}
//
//	/**
//	 * Weixin connected view view.
//	 *
//	 * @return the view
//	 */
//	@Bean({"connect/weixinConnect", "connect/weixinConnected"})
//	@ConditionalOnMissingBean(name = "weixinConnectedView")
//	public View weixinConnectedView() {
//		return new PcConnectView();
//	}
//
//}
