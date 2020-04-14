package com.xp.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Climb.Xu
 * @date 2020/4/11 23:23
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule getRule() {
        return new RandomRule(); //定义为随机
    }
}
