package com.nissan.repo;

public interface ICrudRepository {

	//Create a User
		public void insertEntity();
		
		//List all User
		public void listOfUsers();
		
		//Update User
		public void editUser();
		
		//Disable User
		public void disableUser();
		
		
		//Search by name
		public void searchUserByName();
	
}
