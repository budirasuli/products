package com.modena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Products_Services {

	public static void main(String[] args) {
		SpringApplication.run(Products_Services.class, args);
	}

}
