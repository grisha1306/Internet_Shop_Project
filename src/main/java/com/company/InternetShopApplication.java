package com.company;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Internet Shop API", version = "1.0", description = "Internet Shop Web Service"))
public class InternetShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternetShopApplication.class, args);
    }
}

