package com.digitalhouse.rentcar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "Rent car", version = "v1", description = "Api desenvolvida para o projeto final do curso CTD(Certified Tech Developer"))
public class RentCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentCarApplication.class, args);
	}

}
