package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Employee;
import com.nissan.service.IEmployeeService;


@CrossOrigin		//helps to avoid CORS error
@RestController
@RequestMapping("api/")
public class UserController {

	//field DI Injection
	@Autowired
	IEmployeeService employeeService;
	
	//List all users
	@GetMapping("employees")
	public List<Employee> findAllEmployee(){
		return employeeService.findAllEmployee();
	}
	
	//Get Employee by phone
	@GetMapping("employees/{phone}")
	public Employee searchByPhone(@PathVariable int phone) {
		System.out.println("Inside the controller");
		return employeeService.searchByPhone(phone);
		}
		
	//Add Employee
	@PostMapping("employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		System.out.println("Inserting a record");
		return new ResponseEntity<Employee> (employeeService.addEmployee(employee),HttpStatus.OK);
	}
	
	//Update Employee
	@PutMapping("employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		System.out.println("Updating a record");
		employeeService.updateEmployee(employee);
		return employee;
	}
	
	//Delete Employee
	@DeleteMapping("employees")
	public Employee deleteEmployee(@RequestBody Employee employee) {
		System.out.println("Deleting a record");
		employeeService.deleteEmployee(employee);
		return employee;
	}

}
