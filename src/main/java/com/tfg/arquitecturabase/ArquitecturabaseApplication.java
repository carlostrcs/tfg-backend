package com.tfg.arquitecturabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.tfg.arquitecturabase.repositories")
public class ArquitecturabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquitecturabaseApplication.class, args);
	}

}
