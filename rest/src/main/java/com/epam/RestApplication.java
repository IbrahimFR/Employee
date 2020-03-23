package com.epam.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages={"com.epam.employee.repo",
		"com.epam.employee.service","com.epam.employee.constants"})
@ComponentScan("com.epam.employee.rest.controllers")
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}




}
