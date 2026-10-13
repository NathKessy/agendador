package com.nath.agendador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI agendadorOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Agendador")
                        .description("Documentação da API")
                        .version("1.0"));
    }
}
