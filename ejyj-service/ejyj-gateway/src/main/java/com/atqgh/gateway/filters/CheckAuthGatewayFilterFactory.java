//package com.atqgh.gateway.filters;
//
//import java.net.URI;
//import java.util.Arrays;
//import java.util.List;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.cloud.gateway.support.HttpStatusHolder;
//import org.springframework.util.Assert;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// *d .
// *
// * @author Mubai
// * @since 2022/8/20 2:40 下午
// **/
//public class CheckAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {
//
//    public CheckAuthGatewayFilterFactory() {
//        super(CheckAuthGatewayFilterFactory.Config.class);
//    }
//
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Arrays.asList("");
//    }
//
//    @Override
//    public GatewayFilter apply(String statusString, String urlString) {
//        HttpStatusHolder httpStatus = HttpStatusHolder.parse(statusString);
//        Assert.isTrue(httpStatus.is3xxRedirection(),
//                "status must be a 3xx code, but was " + statusString);
//        final URI url = URI.create(urlString);
//        return apply(httpStatus, url);
//    }
//
//    public GatewayFilter apply(HttpStatusHolder httpStatus, URI uri) {
//        return new GatewayFilter() {
//            @Override
//            public Mono<Void> filter(ServerWebExchange exchange,
//                                     GatewayFilterChain chain) {
//                return null;
//            }
//
//        };
//    }
//
//    public static class Config {
//    }
//}
