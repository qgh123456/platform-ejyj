package com.atqgh.system.provider.config;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 系统管理类的配置 .
 *
 * @author Mubai
 * @since 2022/8/21 10:29 上午
 **/
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:validatecode.properties"})
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    /**
     * 验证码配置类.
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

}
