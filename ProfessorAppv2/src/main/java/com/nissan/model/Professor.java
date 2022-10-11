package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//JPA to map this model class to professor table in db

@Entity
@Table(name="Professor")
//@NamedQuery({
//	@NamedQuery(name="Professor.findByName", query="SELECT p FROM Professor p WHERE p.firstName =: name",Professor.class)
//})
public class Professor {
	
	//declare fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int professorId;
	private String firstName;
	private String lastName;
	private int deptNo;
	private double salary;
	private LocalDate joinDate;
	private LocalDate dateOfBirth;
	private String gender;
	
	//default constructor
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//parameterized constructor
	public Professor(int professorId, String firstName, String lastname, int deptNo, double salary, LocalDate joinDate,
			LocalDate dateOfBirth, String gender) {
		super();
		this.professorId = professorId;
		this.firstName = firstName;
		this.lastName = lastname;
		this.deptNo = deptNo;
		this.salary = salary;
		this.joinDate = joinDate;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	
	//getters and setters
	public int getProfessorId() {
		return professorId;
	}


	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastname) {
		this.lastName = lastname;
	}


	public int getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	//custom methods
	
	
	
	
	//override
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", firstName=" + firstName + ", lastname=" + lastName
				+ ", deptNo=" + deptNo + ", salary=" + salary + ", joinDate=" + joinDate + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + "]";
	}
	
}
