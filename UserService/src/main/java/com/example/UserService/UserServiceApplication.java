package com.example.UserService;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.any())
					.apis(RequestHandlerSelectors.basePackage("com.example.UserService"))
					.build()
					.apiInfo(apiDetails());
		
	}
	
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Admin API Documentation",
				"API for Admin Microservice",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Anushka Sharma", "http://Google.com", "anushkasharma12@gmail.com"),
				"API Licence",
				"http://Google.com",
				Collections.emptyList());
	}
}
