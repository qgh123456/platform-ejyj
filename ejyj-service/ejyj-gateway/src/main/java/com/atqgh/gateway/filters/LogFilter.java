package com.atqgh.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 日志的全局过滤器.
 *
 * @author Mubai
 * @since 2022/8/20 2:58 下午
 **/
@Slf4j
//@Component
public class LogFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info(exchange.getRequest().getPath().value());
        return null;
    }
}
