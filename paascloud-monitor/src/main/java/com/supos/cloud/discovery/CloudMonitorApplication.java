package com.supos.cloud.discovery;

//import com.hazelcast.config.Config;
//import com.hazelcast.config.EvictionPolicy;
//import com.hazelcast.config.ListConfig;
//import com.hazelcast.config.MapConfig;
//import de.codecentric.boot.admin.config.EnableAdminServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;
import de.codecentric.boot.admin.server.web.client.InstanceExchangeFilterFunction;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//import org.springframework.cloud.netflix.turbine.EnableTurbine;


/**
 * The class Paas cloud monitor application.
 *
 * @author walkman
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableTurbine
//@EnableHystrixDashboard
//@EnableCircuitBreaker
@EnableAdminServer
public class CloudMonitorApplication {

    /**
     * Hazelcast config config.
     *
     * @return the config
     */
//    @Bean
//    public Config hazelcastConfig() {
//        return new Config().setProperty("hazelcast.jmx", "true")
//                .addMapConfig(new MapConfig("spring-boot-admin-application-store").setBackupCount(1)
//                        .setEvictionPolicy(EvictionPolicy.NONE))
//                .addListConfig(new ListConfig("spring-boot-admin-event-store").setBackupCount(1)
//                        .setMaxSize(1000));
//    }

    // tag::customization-instance-exchange-filter-function[]
    @Bean
    public InstanceExchangeFilterFunction auditLog() {
        return (instance, request, next) -> next.exchange(request).doOnSubscribe(s -> {
            if (HttpMethod.DELETE.equals(request.method()) || HttpMethod.POST.equals(request.method())) {
//                log.info("{} for {} on {}", request.method(), instance.getId(), request.url());
            }
        });
    }
    // end::customization-instance-exchange-filter-function[]

    // tag::customization-http-headers-providers[]
    @Bean
    public HttpHeadersProvider customHttpHeadersProvider() {
        return instance -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-CUSTOM", "My Custom Value");
            return httpHeaders;
        };
    }
    // end::customization-http-headers-providers[]

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudMonitorApplication.class, args);
    }
}
