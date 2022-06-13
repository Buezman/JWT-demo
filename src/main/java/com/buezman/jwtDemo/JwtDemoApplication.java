package com.buezman.jwtDemo;

import com.buezman.jwtDemo.model.Role;
import com.buezman.jwtDemo.model.AppUser;
import com.buezman.jwtDemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
public class JwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "John Doe", "jdoe", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Tom Cruise", "tcruise", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Ryan Reynolds", "rreynolds", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Angelina Jolie", "angelJ", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "John Wick", "babayega", "1234", new ArrayList<>()));

			userService.addRoleToUser("jdoe", "ROLE_USER");
			userService.addRoleToUser("tcruise", "ROLE_USER");
			userService.addRoleToUser("angelJ", "ROLE_USER");
			userService.addRoleToUser("babayega", "ROLE_ADMIN");
			userService.addRoleToUser("rreynolds", "ROLE_USER");
			userService.addRoleToUser("babayega", "ROLE_USER");
		};
	}


}
