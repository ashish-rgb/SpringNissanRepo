package com.nissan.service;

import java.util.List;

import com.nissan.model.Employee;


public interface IEmployeeService {

		//findAllEmployee
		List<Employee> findAllEmployee();
		
		//Search Employee by Phone
		 Employee searchByPhone(int phone);
		 
		//Insert employee
		 Employee addEmployee(Employee employee);
		 
		
		//Update employee
		Employee updateEmployee(Employee employee);
		
		//Delete employee
		Employee deleteEmployee(Employee employee);
	
}
