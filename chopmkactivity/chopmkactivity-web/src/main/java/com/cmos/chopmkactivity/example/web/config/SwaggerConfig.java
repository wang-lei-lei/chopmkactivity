package com.cmos.chopmkactivity.example.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger基础配置
 * @author Administrator
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket configSpringfoxDocketForAll() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cmos.chopmkactivity.example.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("chopmkactivity REST API文档")
                .description("使用Swagger UI构建SpringMVC REST风格的可视化文档")
                .termsOfServiceUrl("http://127.0.0.1:18080/swagger-ui.html")
                .contact(new Contact("itframe", "http://192.168.100.9:8090/pages/viewpage.action?pageId=3116125", "dangshixu@cmos.chinamobile.com"))
                .version("1.0.0-SNAPSHOT")
                .build();
    }

}
