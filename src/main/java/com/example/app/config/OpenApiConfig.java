package com.example.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Конфигурация Swagger.
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Java Products CRUD-app",
                description = "CRUD-app", version = "1.0.0",
                contact = @Contact(
                        name = "Kutlubaev Artur",
                        email = "kutlub.artur@gmail.com",
                        url = "https://banderlogcumberbatch.github.io/sunoasiss/"
                )
        )
)
public class OpenApiConfig {

}
