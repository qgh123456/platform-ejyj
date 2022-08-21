package com.atqgh.gateway.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

/**
 * 自定义网关断言.
 * 这里面的断言工厂名称，必须要以RoutePredicateFactory结尾，前缀和配置文件的key一致.
 * @author Mubai
 * @since 2022/8/20 12:11 下午
 **/
//@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    public CheckAuthRoutePredicateFactory() {
        super(CheckAuthRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    @Override
    public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {

                if ("baixue".equals(config.getName())) {
                    return true;
                }
                return false;
            }
        };
    }

    @Validated
    public static class Config {

        private String name;

        /**
         * 获取配置文件中的名称.
         * @return 名称
         */
        public String getName() {
            return name;
        }

        /**
         * 获取配置文件中的名称.
         * @param name 名称
         */
        public void setName(String name) {
            this.name = name;
        }
    }
}
