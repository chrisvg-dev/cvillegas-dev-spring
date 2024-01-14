package com.cvillegas.app.main;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MultipartConfig
@EnableEurekaClient
public class MainAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}
}
