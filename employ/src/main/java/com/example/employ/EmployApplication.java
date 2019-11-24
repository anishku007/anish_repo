package com.example.employ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployApplication.class, args);
	}

}
