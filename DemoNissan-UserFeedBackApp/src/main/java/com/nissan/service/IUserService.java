package com.nissan.service;

import java.util.List;

import com.nissan.dto.DtoUserLocationPost;
import com.nissan.model.User;

public interface IUserService {

	//default 
	List<User> getAllUsers();
	
	//list custom post
	List<DtoUserLocationPost> getAllUsersLocationPostsDTO();
	
}
