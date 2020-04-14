package com.xp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Climb.Xu
 * @date 2020/4/8 2:23
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced //请求的地址下如果有多个时 要此注解,负载均衡, 即paymentService是集群情况下 直接请求http://CLOUD-PAYMENT-SERVICE,它不知道是8001还是8002
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
