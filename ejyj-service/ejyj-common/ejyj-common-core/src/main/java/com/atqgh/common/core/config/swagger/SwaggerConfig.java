package com.atqgh.common.core.config.swagger;

import java.util.Collections;
import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger.
 *
 * @author Mubai
 * @since 2022/8/21 9:45 上午
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Resource
    private SwaggerPropertiesConfig swaggerPropertiesConfig;

    /**
     * swagger.
     * @return jieguo
     */
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerPropertiesConfig.getSwagger().getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(swaggerPropertiesConfig.getSwagger()));
    }

    private ApiInfo apiInfo(SwaggerProperties swagger) {
        return new ApiInfo(
                swagger.getTitle(),
                swagger.getDescription(),
                swagger.getVersion(),
                null,
                new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail()),
                swagger.getLicense(), swagger.getLicenseUrl(), Collections.emptyList());
    }
}
