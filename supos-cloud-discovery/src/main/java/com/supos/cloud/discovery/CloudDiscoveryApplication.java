package com.supos.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The class Paas cloud discovery application.
 *
 * @author walkman
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class CloudDiscoveryApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudDiscoveryApplication.class, args);
    }
}
