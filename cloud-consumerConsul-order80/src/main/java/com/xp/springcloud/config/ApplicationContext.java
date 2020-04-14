package com.xp.springcloud.config;

import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Climb.Xu
 * @date 2020/4/11 22:00
 */
@Configuration
public class ApplicationContext {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
