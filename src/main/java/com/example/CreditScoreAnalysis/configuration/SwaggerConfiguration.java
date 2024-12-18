package com.example.CreditScoreAnalysis.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
public class SwaggerConfiguration {
	
//	@Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//            .info(new Info()
//                .title("User Management Service API")
//                .version("1.0")
//                .description("API documentation for the User Management microservice"));
//    }
	
	@Bean
    public OpenAPI customOpenAPI() {
		return new OpenAPI()
                .info(new Info()
                        .title("User Management Service API")
                        .version("3.0.0")
                        .description("API documentation for the User Management microservice"))
                		.addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                		.components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic")));
    
    }
		   @Bean
		    public PasswordEncoder passwordEncoder() {
		        return new BCryptPasswordEncoder();
		    }

		  
		  

}
