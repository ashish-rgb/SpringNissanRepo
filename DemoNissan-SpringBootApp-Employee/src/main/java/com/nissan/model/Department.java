package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TblDepartment")
public class Department {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	private String deptName;
	
	//for One Role Many Users
	@JsonIgnore
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private List<Employee> employee;

	//default constructor
	public Department() {
		super();
	}

	//parameterized constructor
	public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	
	//getters and setters
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	
	//custom methods
	
	//override toString
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", employee=" + employee + "]";
	}
	
	
	
}
