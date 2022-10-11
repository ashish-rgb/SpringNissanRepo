package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Employee;
import com.nissan.repo.IEmployeeRepository;

@Service
public class EmployeeServiceImlp implements IEmployeeService {

	//field injection
		@Autowired
		IEmployeeRepository employeeRepo;
		
		
	
	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepo.findAll();
	}

	@Override
	public Employee searchByPhone(int phone) {
		// TODO Auto-generated method stub
		Employee _employee = employeeRepo.searchByPhone(phone);
		
		//check condition
		if(phone == _employee.getPhone()) {
			return _employee;
		}else {
			return null;
		}
	}

	@Transactional
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	
	@Override
	public Employee deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

}
