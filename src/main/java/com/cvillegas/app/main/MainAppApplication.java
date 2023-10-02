package com.cvillegas.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.annotation.MultipartConfig;

@SpringBootApplication
@MultipartConfig
public class MainAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}

}
