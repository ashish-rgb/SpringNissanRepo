package com.nissan.module;

import java.time.LocalDate;

public class Login {

	private int userId;
	private String userName;
	private String userPass;
	private String role;
	private LocalDate createdDate;
	
	//default constructor
	public Login() {
		super();
	}


	//parameterized constructor
	public Login(int userId, String userName, String userPass, String role, LocalDate createdDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.role = role;
		this.createdDate = createdDate;
	}
	
	public Login( String userName, String userPass, String role, LocalDate createdDate) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.role = role;
		this.createdDate = createdDate;
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


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}


	//override toString()
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", role=" + role
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	
	
}
