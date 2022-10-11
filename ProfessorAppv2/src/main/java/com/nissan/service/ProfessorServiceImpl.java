package com.nissan.service;

import java.util.Scanner;

import com.nissan.repo.CrudRepositoryImpl;
import com.nissan.repo.ICrudRepository;

public class ProfessorServiceImpl {
	
	//constructor Injection
	//call methods
	ICrudRepository crud = new CrudRepositoryImpl();
//	ICrudRepository crud ;
	
	Scanner input = new Scanner(System.in);
	char choice = 'y';
	
	//default constructor
	public ProfessorServiceImpl() {
		
	}
	
	public ProfessorServiceImpl(ICrudRepository _crud) {
		this.crud = _crud;
	}
	
	//Menu Driven
	public void menuDriven() {
		do {
			//show choice
			System.out.println("\n 1. Add Professor \n 2. Edit Professor \n 3. Search Professor by ID \n 4. Delete Professor \n 5. Find All Professors \n 6. Search Professor by name \n Enter your option : ");
			int option = input.nextInt();
			
			switch(option) {
			case 1:
				crud.insertEntity();
				break;
				
			case 2:
				crud.updateProfessor();
				break;
				
			case 3:
				crud.searchProfessor();
				break;
				
			case 4:
				crud.deleteProfessor();
				break;
				
			case 5:
				crud.listOfProfessors();
				break;
				
			case 6:
				crud.searchProfessorByName();
				break;
			}
		}while(choice == 'y' || choice == 'Y');
	}
	
	
	
}
