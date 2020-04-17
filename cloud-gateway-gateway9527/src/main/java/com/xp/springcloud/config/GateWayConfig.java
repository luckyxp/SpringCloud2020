package com.xp.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Climb.Xu
 * @date 2020/4/17 22:19
 */
@Configuration
public class GateWayConfig {
    //编码实现网关配置
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder) {
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route",
                r -> r.path("/ent") //访问ent,转发到http://news.baidu.com/ent
                        .uri("http://news.baidu.com/ent")).build();
        return routes.build();
    }

}
