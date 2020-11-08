package com.smartinvoice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.*")
@EnableJpaRepositories("com.smartinvoice.dao")
@EntityScan("com.smartinvoice.model")
public class SmartInvoice {

	public static void main(String[] args) {
		SpringApplication.run(SmartInvoice.class, args);
	}
}
