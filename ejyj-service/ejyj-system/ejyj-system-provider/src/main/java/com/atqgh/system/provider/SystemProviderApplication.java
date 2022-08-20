package com.atqgh.system.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 系统资源服务启动类.
 *
 * @author Mubai
 * @date 2022/6/30 11:00 上午
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.atqgh.system.provider.mapper")
public class SystemProviderApplication {

    /**
     * 系统启动类.
     * @param args 请求参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SystemProviderApplication.class, args);
    }
}
