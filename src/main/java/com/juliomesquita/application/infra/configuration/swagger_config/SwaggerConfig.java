package com.juliomesquita.application.infra.configuration.swagger_config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
    public SwaggerConfig() {
    }

    @Bean
    public OpenAPI openAPI() {
        final String apiTitle = String.format("%s API", StringUtils.capitalize("WebFlux Application"));
        return new OpenAPI()
                .info(new Info().
                        title(apiTitle)
                        .version("V1")
                        .summary("API WebFlux Application")
                        .description(new StringBuilder()
                                .append("Bs;ldkfj;sla")
                                .append("\n\n")
                                .append(".skdnf/alsk;")
                                .toString())
                        .termsOfService("https://github.com/devjuliomesquita/WebFLuxApplication")
                        .contact(new Contact().name("Júlio Mesquita").email("juliocesarmcamilo@gmail.com").url("https://github.com/devjuliomesquita"))
                        .license(new License().name("MIT License").url("https://github.com/devjuliomesquita/WebFLuxApplication/blob/main/LICENSE"))
                )
                .servers(new ArrayList<>(List.of(new Server().description("Ambiente LOCAL").url("http://localhost:8080")))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Reactive Streams")
                        .url("https://docs.spring.io/spring-data/relational/reference/")
                );

    }

}
