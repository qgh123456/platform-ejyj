package com.atqgh.common.core.config.swagger;

import lombok.Data;

/**
 *swagger的实体类 .
 *
 * @author Mubai
 * @since 2022/8/20 11:04 下午
 **/
@Data
public class SwaggerProperties {

    private String basePackage;

    private String title;

    private String description;

    private String version;

    private String author;

    private String url;

    private String email;

    private String license;

    private String licenseUrl;

}
