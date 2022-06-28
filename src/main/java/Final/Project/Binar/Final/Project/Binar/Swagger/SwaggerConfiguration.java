package Final.Project.Binar.Final.Project.Binar.Swagger;


import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@EnableSwagger2
@Component
public class SwaggerConfiguration {
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Lists.newArrayList(apiKey()))
                .securityContexts(Lists.newArrayList(securityContext()))
                .apiInfo(apiInfo());
    }

    @Bean
    SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();

    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("JWT", authorizationScopes));

    }

    private ApiKey apiKey()
    {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Sneakers Api")
                .description("Api Sneakers")
                .termsOfServiceUrl("https://www.binaracademy.com/")
                .license("Java BE 2 Group 1")
                .build();
    }
}