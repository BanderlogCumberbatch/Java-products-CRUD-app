package com.example.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@EnableWebMvc
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
