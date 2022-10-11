package com.nissan.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nissan.module.Login;


public class CrudRepositoryImpl implements ICrudRepository {

	public void insertEntity() {
		//EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		Scanner input = new Scanner(System.in);
		
		//start process
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			//start transaction
			transaction.begin();
			
			//create an object of professor
			Login login = new Login();
			
			//get input from user
			System.out.print("Enter the User name : ");
			login.setUserName(input.nextLine());
			
			
			System.out.print("Enter the password : ");
			login.setUserPass(input.nextLine());
			
			System.out.print("Enter the role : ");
			login.setRole(input.nextLine());
			
			System.out.print("Enter the Date of Birth (dd-mm-yy) : ");
			login.setCreatedDate(LocalDate.parse(input.nextLine()));
			
			
			//ORM
			entityManager.persist(login);
			
			//DB
			transaction.commit();
			
		}
		catch(Exception e) {
			transaction.rollback();
		}
		finally {
			emf.close();
		}
		
	}

	public void listOfUsers() {
		
		//EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			
			//list of professors//KPQL - Java Persistence Query Language
			List<Login> loginUsers = (List<Login>) entityManager.createQuery("from Login");
			for (Login loginUser : loginUsers) {
				System.out.println("User ID : "+loginUser.getUserId());
				System.out.println("User Name : "+loginUser.getUserName());
				System.out.println("User Password : "+loginUser.getUserPass());
				System.out.println("User Role : "+loginUser.getRole());
				System.out.println("Created date : "+loginUser.getCreatedDate());
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			emf.close();
		}
		
	}

	public void editUser() {
		
		Scanner input = new Scanner(System.in);

		//EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			//search
			System.out.println("Enter User Id : ");
			int id = Integer.parseInt(input.nextLine());
			
			//select from entity manager
			Login user = entityManager.find(Login.class, id);
			
			//change first and last name
			System.out.println("Enter the user name : ");
			user.setUserName(input.nextLine());
			
			System.out.println("Enter the role : ");
			user.setRole(input.nextLine());
			
			//committing
			entityManager.getTransaction().commit();
			

			//after update
			System.out.println(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			emf.close();
		}
		
	}

	public void disableUser() {

		Scanner input = new Scanner(System.in);

		//EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			//search
			System.out.println("Enter User Id : ");
			int id = Integer.parseInt(input.nextLine());
			
			//select from entity manager
			Login user = entityManager.find(Login.class, id);
			
			//delete
			entityManager.remove(user);
			
			//committing
			entityManager.getTransaction().commit();
			

			//after update
			System.out.println("Record has been Deleted...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			emf.close();
		}
		
		
	}


	public void searchUserByName() {
		Scanner input = new Scanner(System.in);

		//EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			//search
			System.out.println("Enter Users Name : ");
			String searchingName= input.nextLine();
			
			//select from entity manager
			Login user = (Login) entityManager.createQuery("SELECT l FROM Login l WHERE l.userName =: name",Login.class).setParameter("username", searchingName).getSingleResult();
			
			
			
			//printing professor info
			System.out.println("Users ID : "+user.getUserId());
			System.out.println("Users Name : "+user.getUserName());
			System.out.println("User Password : "+user.getUserPass());
			System.out.println("Created date : "+user.getCreatedDate());
			System.out.println("User role : "+user.getRole());
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			emf.close();
		}
	
}
}
