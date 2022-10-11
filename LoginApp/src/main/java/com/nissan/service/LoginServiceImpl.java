package com.nissan.service;

import java.util.Scanner;

import com.nissan.repo.CrudRepositoryImpl;
import com.nissan.repo.ICrudRepository;

public class LoginServiceImpl {


	//constructor Injection
	//call methods
	ICrudRepository crud = new CrudRepositoryImpl();
//	ICrudRepository crud ;
	
	Scanner input = new Scanner(System.in);
	char choice = 'y';
	
	//default constructor
	public LoginServiceImpl() {
		
	}
	
	public LoginServiceImpl(ICrudRepository _crud) {
		this.crud = _crud;
	}
	
	//Menu Driven
	public void menuDriven() {
		do {
			//show choice
			System.out.println("\n 1. Add user \n 2. Edit User \n 3. Search User by Name \n 4. Disable User \n 5. Find All User \n Enter your option : ");
			int option = input.nextInt();
			
			switch(option) {
			case 1:
				crud.insertEntity();
				break;
				
			case 2:
				crud.editUser();
				break;
				
			case 3:
				crud.searchUserByName();
				break;
				
			case 4:
				crud.disableUser();
				break;
				
			case 5:
				crud.listOfUsers();
				break;
			
			}
		}while(choice == 'y' || choice == 'Y');
	}
	
}
