package com.project.onlinelearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.project.onlinelearning.repository")
@EntityScan("com.project.onlinelearning.model")
public class OnlinelearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinelearningApplication.class, args);
	}
}
