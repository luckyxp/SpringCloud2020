package com.xp.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;

/**
 * @author Climb.Xu
 * @date 2020/4/14 20:45
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; //详细日志 还有NONE,BASIC,HEADERS
    }
}
