package com.alkemy.challenge.swagger;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

@Configuration
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class OpenApiConfig {

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info().title("Swagger Documentation Api Disney").description("App Disney").version("v1.0")
				.contact(new Contact().name("Gi").url("").email(""))
				.termsOfService("TOC").license(new License().name("License").url("#")));
	}
}