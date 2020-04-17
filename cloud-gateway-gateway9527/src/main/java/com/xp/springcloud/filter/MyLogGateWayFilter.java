package com.xp.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author Climb.Xu
 * @date 2020/4/17 23:11
 * gateway过滤器
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("==============进来全局过滤器MyLogGateWayFilter" + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("========用户名为null,非法用户,打出");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE); //可以设置一些值 下一个过滤器可以使用
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //加载过滤器的顺序,数字越小,优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
