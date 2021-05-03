package com.cowin.apis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * This configuration class takes care of Swagger2 setup
 * @author navneetprabhakar
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "CoWin API Interface",
                "These APIs provide interface to CoWin Public APIs to search Appointments",
                "v1.0",
                "Terms of service",
                new Contact("Navneet Prabhakar", "https://www.linkedin.com/in/navneetprabhakar/", "navneet.prabhakar007@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
