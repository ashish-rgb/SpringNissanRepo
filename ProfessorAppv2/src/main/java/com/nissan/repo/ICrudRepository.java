package com.nissan.repo;

public interface ICrudRepository {

	//Create a professor
	public void insertEntity();
	
	//List all professors
	public void listOfProfessors();
	
	//Update professor
	public void updateProfessor();
	
	//Delete professor
	public void deleteProfessor();
	
	//Search by Id
	public void searchProfessor();
	
	//Search by name
	public void searchProfessorByName();
}
