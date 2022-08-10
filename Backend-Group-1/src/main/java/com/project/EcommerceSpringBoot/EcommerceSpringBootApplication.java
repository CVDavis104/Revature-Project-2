package com.project.EcommerceSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan("com.project.EcommerceSpringBoot.models")
@EnableTransactionManagement
@EnableJpaRepositories("com.project.EcommerceSpringBoot.repos")
@EnableJpaAuditing
@SpringBootApplication
public class EcommerceSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceSpringBootApplication.class, args);
	}

}
