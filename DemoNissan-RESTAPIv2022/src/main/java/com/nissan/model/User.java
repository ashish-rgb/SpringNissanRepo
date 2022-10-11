package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="TblUser")
public class User {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(nullable=false,unique=true)
	private String userName;
	
	@Column(nullable=false)
	private String password;
	private String fullName;
	private boolean isActive;
	
								 //User.roleId=Role.roleId
	@JoinColumn(name ="roleId")	 //role_role.role_id	
	@ManyToOne					 //@JoinColumn(name ="roleId",insertable=false,updatable=true)	
	private Role role;    

	//default constructor
	public User() {
		super();
	}

	//parameterized
	public User(int userId, String userName, String password, String fullName, boolean isActive, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.isActive = isActive;
		this.role = role;
	}

	//getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	//@JsonBackReference			//avoid recursive
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	//custom methods
	
	//override toString
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", isActive=" + isActive + ", role=" + role + "]";
	}
	
	
	
}
