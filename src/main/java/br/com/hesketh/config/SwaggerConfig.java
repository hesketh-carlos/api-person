package br.com.hesketh.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${server.servlet.context-path}")
    private String url;

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api-hesketh")
                .packagesToScan("br.com.hesketh.controller")
                .build();
    }

    @Bean
    public OpenAPI customApi() {
        return new OpenAPI()
                .addServersItem(new Server().url(url))
                .info(new Info()
                        .title("Api - Hesketh")
                        .description("Uma API para person")
                        .version("v1.0.0"));
    }
}
