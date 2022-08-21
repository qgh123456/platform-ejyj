package com.atqgh.common.core.config;

import com.atqgh.common.core.handler.GlobalExceptionHandler;
import com.atqgh.common.core.utils.RedisUtils;
import com.atqgh.common.core.utils.SpringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类.
 * @author Mubai
 * @date 2022/7/9 4:26 下午
 **/
@Configuration
@ComponentScan(basePackages = "com.atqgh.common.core")
public class AutoCoreConfiguration {

    /**
     * spring工具.
     * @return bean
     */
    @Bean
    public SpringUtils springUtils() {
        return new SpringUtils();
    }

    /**
     * 配置全局异常的拦截处理器.
     * @return bean
     */
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    /**
     * 自定义feignClient的bean的后置处理器.
     * @return feignClient的bean的后置处理器
     */
//    @Bean
//    public MyFeignClientBeanProcessor myFeignClientBeanProcessor() {
//        return new MyFeignClientBeanProcessor();
//    }
}
