package com.xp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Climb.Xu
 * @date 2020/4/17 23:38
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenterMian3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMian3344.class, args);
    }
}
