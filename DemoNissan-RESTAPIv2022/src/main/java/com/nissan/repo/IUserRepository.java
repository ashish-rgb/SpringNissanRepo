package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.User;

@Repository
public interface IUserRepository extends JpaRepositoryImplementation<User, Integer> {

	// Spring data JPA -- JPARepositoryImplementation , CrudRepository

	//Custom Retrieve username and password
	@Query("from User where userName=?1 and password=?2 and isActive=true")
	public User findByUserNameAndPassword(String userName,String password);
	
	//Custom Retrieve name
	@Query("from User where fullName=?1")
	public User searchByName(String fullName);
	
	
}
