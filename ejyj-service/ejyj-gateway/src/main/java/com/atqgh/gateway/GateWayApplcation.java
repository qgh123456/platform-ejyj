package com.atqgh.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类.
 *
 * @author Mubai
 * @since 2022/8/18 11:07 下午
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplcation {

    /**
     * 启动.
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplcation.class, args);
    }
}
