package com.nissan.service;

import java.util.List;

import com.nissan.model.User;

public interface IUserService {

	//findAllUsers
	List<User> findAllUsers();
	
	//Find User by Username and Password
	 User findByUserNameAndPassword(String userName,String password);
	
	//Search User by Name
	 User searchByName(String fullName);
	 
	//Insert User
	 User addUser(User user);
	 
	//User insertUser(User user);
	
	//Update User
	User updateUser(User user);
}
