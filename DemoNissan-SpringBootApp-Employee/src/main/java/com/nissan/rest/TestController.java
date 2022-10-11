package com.nissan.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	// http://localhost:9096/          endpoint
	
		@GetMapping("/")
		public String sayHello() {
			return "Employee";
		}
		
		// http://localhost:9095/workout       endpoint
		@RequestMapping("/employees")
		public String getDailyWorkOut() {
			return "All Employee";
		}
	
}
