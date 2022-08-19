package com.atqgh.common.config;

import com.atqgh.common.handler.GlobalExceptionHandler;
import com.atqgh.common.utils.SpringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类.
 * @author Mubai
 * @date 2022/7/9 4:26 下午
 **/
@Configuration
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
