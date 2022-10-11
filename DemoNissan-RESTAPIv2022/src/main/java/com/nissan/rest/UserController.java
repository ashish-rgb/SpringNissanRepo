package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.User;
import com.nissan.service.IUserService;

@CrossOrigin		//helps to avoid CORS error
@RestController
@RequestMapping("api/")
public class UserController {

	//field DI Injection
	@Autowired
	IUserService userService;
	
	//List all users
	@GetMapping("users")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	//Get User by Username and password
	@GetMapping("users/{userName}&{password}")
	public User findUserByNameUserAndPassword(@PathVariable String userName, @PathVariable String password) {
		System.out.println("Inside the controller");
		return userService.findByUserNameAndPassword(userName, password);
	}
	
	//Get User by Name
	@GetMapping("users/{fullName}")
	public User searchByName(@PathVariable String fullName) {
		System.out.println("Inside the controller");
		return userService.searchByName(fullName);
		}
		
	//Add User
	@PostMapping("users")
	public ResponseEntity<User> addUser(@RequestBody User user){
		System.out.println("Inserting a record");
		return new ResponseEntity<User> (userService.addUser(user),HttpStatus.OK);
	}
	
	//Update User
	@PutMapping("users")
	public User updateUser(@RequestBody User user) {
		System.out.println("Updating a record");
		userService.updateUser(user);
		return user;
	}
}
