package com.supos.cloud.security.core.social.qq.config;

import com.supos.cloud.security.core.properties.QQProperties;
import com.supos.cloud.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

import com.supos.cloud.security.core.properties.SecurityProperties;


/**
 * The class Qq auto config.
 *
 * @author walkman
 */
@Configuration
@ConditionalOnProperty(prefix = "paascloud.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialConfigurerAdapter {

    private final SecurityProperties securityProperties;

    @Autowired
    public QQAutoConfig(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * Create connection factory connection factory.
     *
     * @return the connection factory
     */
//    @Override
//    protected ConnectionFactory<?> createConnectionFactory() {
//        QQProperties qqConfig = securityProperties.getSocial().getQq();
//        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
//    }
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        super.addConnectionFactories(connectionFactoryConfigurer, environment);
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        connectionFactoryConfigurer.addConnectionFactory(
                new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.get(), qqConfig.g()));
        connectionFactoryConfigurer.addConnectionFactory(
                new YConnectionFactory(yProperties.getProviderId(), yProperties.getAppId(), yProperties.getAppSecret()));
    }


}
