package com.example.apicep;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenAPI", version ="2",description = "Documentação da API REST Library"))
public class ApicepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicepApplication.class, args);
	}

}
