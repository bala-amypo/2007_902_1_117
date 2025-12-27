package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        Server httpsServer = new Server();
        httpsServer.setUrl("https://9022.408procr.amypo.ai");
        httpsServer.setDescription("Production HTTPS Server");

        return new OpenAPI()
                .info(new Info()
                        .title("IT Policy Violation Detection API")
                        .version("1.0"))
                .servers(List.of(httpsServer))
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .components(
                        new io.swagger.v3.oas.models.Components()
                                .addSecuritySchemes("BearerAuth",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT"))
                );
    }
}
