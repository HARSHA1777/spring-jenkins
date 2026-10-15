package com.employee;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.service.EmployeeService;

@SpringBootApplication
public class SpringJenkinsApplication {
	
	private static final Logger logger =
	        LoggerFactory.getLogger(EmployeeService.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJenkinsApplication.class, args);
	}

}
