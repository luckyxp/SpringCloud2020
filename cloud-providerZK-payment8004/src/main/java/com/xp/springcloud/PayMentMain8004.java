package com.xp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Climb.Xu
 * @date 2020/4/8 0:30
 */
@SpringBootApplication
@EnableDiscoveryClient //用于向使用consul或者zookeepper作为注册中心时注册服务
public class PayMentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8004.class,args);
    }
}
