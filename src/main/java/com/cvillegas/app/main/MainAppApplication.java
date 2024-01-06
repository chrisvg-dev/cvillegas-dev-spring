package com.cvillegas.app.main;

import com.cvillegas.app.main.enums.Level;
import com.cvillegas.app.main.enums.SkillCategory;
import com.cvillegas.app.main.model.*;
import com.cvillegas.app.main.model.repository.*;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@MultipartConfig
@Slf4j
public class MainAppApplication implements CommandLineRunner {
	@Autowired private RoleRepository roleRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private ISettingsRepository settingsRepository;
	@Autowired private IJobRepository jobRepository;
	@Autowired private ITechnicalSkillRepository technicalSkillRepository;
	@Autowired private ISkillCategoryRepository categoryRepository;
	@Autowired private IProjectRepository projectRepository;
	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*this.roleRepository.saveAll(
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

		this.jobRepository.saveAll(List.of(
				Job.builder().name("Java Developer").company("C&A Systems S.A. de C.V.").description("Java developer").isCurrent(true).build()
		));

		this.categoryRepository.saveAll(List.of(
				TechSkillCategory.builder().skillCategory(SkillCategory.BACKEND).build(),
				TechSkillCategory.builder().skillCategory(SkillCategory.FRONTEND).build(),
				TechSkillCategory.builder().skillCategory(SkillCategory.DATABASE).build(),
				TechSkillCategory.builder().skillCategory(SkillCategory.DEVOPS).build()
		));

		TechSkillCategory backend = this.categoryRepository.findBySkillCategory(SkillCategory.BACKEND).orElseThrow();
		TechSkillCategory frontend = this.categoryRepository.findBySkillCategory(SkillCategory.FRONTEND).orElseThrow();
		TechSkillCategory devops = this.categoryRepository.findBySkillCategory(SkillCategory.DEVOPS).orElseThrow();

		this.technicalSkillRepository.saveAll(List.of(
				TechnicalSkill.builder()
						.name("Java")
						.description("Java")
						.category(backend)
						.icon("fas fa-code")
						.styleClass("card l-bg-cherry")
						.level(Level.ADVANCED)
						.build(),
				TechnicalSkill.builder()
						.name("Angular")
						.description("Java")
						.category(frontend)
						.icon("fas fa-code")
						.styleClass("card l-bg-blue-dark")
						.level(Level.ADVANCED)
						.build(),
				TechnicalSkill.builder()
						.name("Java")
						.description("Java")
						.category(backend)
						.icon("fas fa-code")
						.styleClass("card l-bg-green-dark")
						.level(Level.ADVANCED)
						.build(),
				TechnicalSkill.builder()
						.name("Docker")
						.description("Docker")
						.category(devops)
						.icon("fas fa-code")
						.styleClass("card l-bg-orange-dark")
						.level(Level.ADVANCED)
						.build()
		));
		this.projectRepository.saveAll(List.of(
				Project.builder()
                        .title("Personal website")
                        .description("My personal website.")
						.type("API")
						.url("https://api.cristhianvg.dev/swagger-ui/index.html")
						.observations("Proyecto personal para compartir mis habilidades y practicar algunas cosas.")
                        .build()
		));*/
		// this.categoryRepository.save(TechSkillCategory.builder().skillCategory(SkillCategory.OTHERS).build());
		TechSkillCategory cloud = this.categoryRepository.findBySkillCategory(SkillCategory.CLOUD).orElseThrow();
		/*this.technicalSkillRepository.save(
				TechnicalSkill.builder()
						.name("Amazon Web Services")
						.description("AWS")
						.category(cloud)
						.icon("fas fa-code")
						.styleClass("card l-bg-cherry")
						.level(Level.MEDIUM)
						.build());
	*/}
}
