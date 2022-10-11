package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoNissanSpringBootAppEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNissanSpringBootAppEmployeeApplication.class, args);
		System.out.println("Connection Successfull");
	}

}
