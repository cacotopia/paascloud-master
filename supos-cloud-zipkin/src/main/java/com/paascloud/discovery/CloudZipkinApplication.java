package com.supos.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * The class Paas cloud zipkin application.
 *
 * @author walkman
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class CloudZipkinApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudZipkinApplication.class, args);
    }
}
