package com.cvillegas.app.main;

import jakarta.servlet.annotation.MultipartConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MultipartConfig
@Slf4j
public class MainAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}
}
