package com.supos.cloud.provider.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.supos.cloud.config.properties.PaascloudProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * The class Aliyun sms configuration.
 *
 * @author walkman
 */
@Slf4j
@Configuration
public class AliyunSmsConfiguration {

	@Resource
	private PaascloudProperties paascloudProperties;

	/**
	 * Acs client acs client.
	 *
	 * @return the acs client
	 *
	 * @throws ClientException the client exception
	 */
	@Bean
	public IAcsClient acsClient() throws ClientException {
		log.info("SMS Bean IAcsClient Start");
		IClientProfile profile = DefaultProfile.getProfile(paascloudProperties.getAliyun().getSms().getRegionId(), paascloudProperties.getAliyun().getKey().getAccessKeyId(), paascloudProperties.getAliyun().getKey().getAccessKeySecret());
		DefaultProfile.addEndpoint(paascloudProperties.getAliyun().getSms().getEndpointName(), paascloudProperties.getAliyun().getSms().getRegionId(), paascloudProperties.getAliyun().getSms().getProduct(), paascloudProperties.getAliyun().getSms().getDomain());
		DefaultAcsClient defaultAcsClient = new DefaultAcsClient(profile);
		log.info("加载SMS Bean IAcsClient OK");
		return defaultAcsClient;
	}

}
