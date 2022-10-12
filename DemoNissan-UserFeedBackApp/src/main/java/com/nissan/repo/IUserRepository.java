package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.dto.DtoUserLocationPost;
import com.nissan.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {

	//custom JPQL Query , which is retrieving
	//userId,userName,locationName,postDetails
	//from User,Location and Post based on PK-FK relationship
	@Query("SELECT new com.nissan.dto.DtoUserLocationPost"
			+ " (u.userId,u.firstName,l.locationName,p.postDetail)"
			+ "FROM User u INNER JOIN u.location l"
			+ "INNER JOIN u.posts p ORDER BY u.userId")
	List<DtoUserLocationPost> getAllUsersLocPosts();
}
