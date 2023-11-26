package com.cvillegas.app.main;

import com.cvillegas.app.main.model.Setting;
import com.cvillegas.app.main.model.repository.ISettingsRepository;
import com.cvillegas.app.main.security.enums.ERole;
import com.cvillegas.app.main.security.model.AllowedUrl;
import com.cvillegas.app.main.security.model.Role;
import com.cvillegas.app.main.security.model.User;
import com.cvillegas.app.main.security.repository.IAllowedUrlRepository;
import com.cvillegas.app.main.security.repository.RoleRepository;
import com.cvillegas.app.main.security.repository.UserRepository;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@MultipartConfig
@Slf4j
public class MainAppApplication implements CommandLineRunner {
	@Autowired private RoleRepository roleRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private ISettingsRepository settingsRepository;
	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.settingsRepository.saveAll(List.of(
				Setting.builder()
						.param("AUTHORIZATION_DOMAIN")
						.content("")
						.description("The authorization domain")
						.build(),
				Setting.builder()
						.param("AUTHORIZATION_COOKIE_NAME")
						.content("authToken")
						.description("The authorization cookie name")
						.build()
		));
		this.roleRepository.saveAll(
				List.of(
						Role.builder().roleName(ERole.ROLE_ADMIN).build(),
						Role.builder().roleName(ERole.ROLE_USER).build()
				)
		);
		this.userRepository.save(User.builder()
				.name("CRISTHIAN")
				.lastName("VILLEGAS")
				.email("cristianvg9692@gmail.com")
				.password(new BCryptPasswordEncoder().encode("Pa28d8896f9#1992"))
				.build()
		);

	}
}
