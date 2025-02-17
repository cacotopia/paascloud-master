package com.supos.cloud.core.config;

import com.supos.cloud.config.properties.PaascloudProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * The class Async config.
 *
 * @author walkman
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncTaskExecutorConfiguration implements AsyncConfigurer {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private PaascloudProperties paascloudProperties;

    @Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(paascloudProperties.getTask().getCorePoolSize());
        executor.setMaxPoolSize(paascloudProperties.getTask().getMaxPoolSize());
        executor.setQueueCapacity(paascloudProperties.getTask().getQueueCapacity());
        executor.setKeepAliveSeconds(paascloudProperties.getTask().getKeepAliveSeconds());
        executor.setThreadNamePrefix(paascloudProperties.getTask().getThreadNamePrefix());
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
