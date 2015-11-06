package org.istic.taa;
import com.google.common.base.Predicate;
import org.istic.taa.resources.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.collect.Lists.*;

/**
 * Created by stephane on 06/10/15.
 */
@SpringBootApplication
@EnableSwagger2 //Enable swagger 2.0 spec
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = {
        SpringFoxApi.class, // Main API entrypoint
        TeamResources.class,
        UserResources.class,
        TaskResources.class,
        SprintResources.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket userApi() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder()
                .scope("read")
                .description("read access")
                .build();
        SecurityReference securityReference = SecurityReference.builder()
                .reference("test")
                .scopes(authScopes)
                .build();

        ArrayList<SecurityContext> securityContexts = newArrayList(SecurityContext.builder().securityReferences
                (newArrayList(securityReference)).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(newArrayList(new BasicAuth("test")))
                .securityContexts(securityContexts)
                .groupName("user-api")
                .apiInfo(apiInfo())
                .select()
                .paths(userOnlyEndpoints())
                .build();
    }

    private Predicate<String> userOnlyEndpoints() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains("user");
            }
        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SprinfFox API")
                .description("")
                .termsOfServiceUrl("http://springfox.io")
                .contact("springfox")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
