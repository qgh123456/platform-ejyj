package com.atqgh.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 验证配置.
 * @author Mubai
 * @date 2022/7/17 10:23 上午
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "code")
public class ValidateCodeProperties {

    /**
     * 验证码有效时间，单位秒.
     */
    private Long time = 120L;

    /**
     * 验证码类型，可选值 png和 gif.
     */
    private String type = "png";

    /**
     * 图片宽度，px.
     */
    private Integer width = 130;

    /**
     * 图片高度，px.
     */
    private Integer height = 48;

    /**
     * 验证码位数.
     */
    private Integer length = 4;

    /**
     * 验证码值的类型.
     * 1. 数字加字母
     * 2. 纯数字
     * 3. 纯字母
     */
    private Integer charType = 2;
}
