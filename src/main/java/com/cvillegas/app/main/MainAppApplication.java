package com.cvillegas.app.main;

import com.cvillegas.app.main.security.enums.ERole;
import com.cvillegas.app.main.security.model.Role;
import com.cvillegas.app.main.security.repository.RoleRepository;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MultipartConfig
@Slf4j
public class MainAppApplication implements CommandLineRunner {
	@Autowired private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*this.roleRepository.saveAll(
				List.of(
						Role.builder().roleName(ERole.ROLE_ADMIN).build(),
						Role.builder().roleName(ERole.ROLE_USER).build()
				)
		);*/
	}
}
