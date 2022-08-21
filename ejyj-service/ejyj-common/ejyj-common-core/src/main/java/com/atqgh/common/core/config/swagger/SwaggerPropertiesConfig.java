package com.atqgh.common.core.config.swagger;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * swagger.
 *
 * @author Mubai
 * @since 2022/8/20 10:37 下午
 **/
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:swagger.properties"})
@ConfigurationProperties(prefix = "ejyj.server")
public class SwaggerPropertiesConfig {

    private SwaggerProperties swagger = new SwaggerProperties();

}
