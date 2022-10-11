package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TblEmployee")
public class Employee {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(nullable=false,unique=true)
	private String empName;
	
	@Column(nullable=false)
	private String designation;
	private int salary;
	private LocalDate joinDate;
	private int phone;
	private boolean isActive;
	
	@JoinColumn(name ="deptId")	 
	@ManyToOne					 	
	private Department department;

	//default
	public Employee() {
		super();
	}

	//parameterized
	public Employee(int empId, String empName, String designation, int salary, LocalDate joinDate,
			int phone,boolean isActive,Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.salary = salary;
		this.joinDate = joinDate;
		this.phone = phone;
		this.isActive = isActive;
		this.department = department;
	}


	//getters and setters
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}

	//override toString
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", salary="
				+ salary + ", joinDate=" + joinDate + ", phone=" + phone + ", isActive=" + isActive + ", department="
				+ department + "]";
	}

	
	


	
	
	
	
	
	
}
