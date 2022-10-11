package com.nissan.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nissan.model.Professor;

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
			Professor professor = new Professor();
			
			//get input from user
			System.out.print("Enter the first name : ");
			professor.setFirstName(input.nextLine());
			
			System.out.print("Enter the last name : ");
			professor.setLastName(input.nextLine());
			
			System.out.print("Enter the Department No : ");
			professor.setDeptNo(Integer.parseInt(input.nextLine()));
			
			System.out.print("Enter the Salary : ");
			professor.setSalary(Integer.parseInt(input.nextLine()));
			
			System.out.print("Enter the Joining Date (dd-mm-yy) : ");
			professor.setJoinDate(LocalDate.parse(input.nextLine()));
			
			System.out.print("Enter the Date of Birth (dd-mm-yy) : ");
			professor.setDateOfBirth(LocalDate.parse(input.nextLine()));
			
			System.out.print("Enter your Gender : ");
			professor.setGender(input.nextLine());
			
			
			//ORM
			entityManager.persist(professor);
			
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

	public void listOfProfessors() {
		
		//EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			
			//list of professors//KPQL - Java Persistence Query Language
			List<Professor> professors = (List<Professor>) entityManager.createQuery("from Professor");
			for (Professor professor : professors) {
				System.out.println("Professor ID : "+professor.getProfessorId());
				System.out.println("Professor First Name : "+professor.getFirstName());
				System.out.println("Professor Last Name : "+professor.getLastName());
				System.out.println("Professor Department No. : "+professor.getDeptNo());
				System.out.println("Professor Salary : "+professor.getSalary());
				System.out.println("Professor Joining Date : "+professor.getJoinDate());
				System.out.println("Professor Date of Birth : "+professor.getDateOfBirth());
				System.out.println("Professor Gender : "+professor.getGender());
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

	public void updateProfessor() {
		
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
			System.out.println("Enter Professor Id : ");
			int id = Integer.parseInt(input.nextLine());
			
			//select from entity manager
			Professor pro = entityManager.find(Professor.class, id);
			
			//change first and last name
			System.out.println("Enter the first name : ");
			pro.setFirstName(input.nextLine());
			
			System.out.println("Enter the last name : ");
			pro.setLastName(input.nextLine());
			
			//committing
			entityManager.getTransaction().commit();
			

			//after update
			System.out.println(pro);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			emf.close();
		}
		
	}

	public void deleteProfessor() {

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
			System.out.println("Enter Professor Id : ");
			int id = Integer.parseInt(input.nextLine());
			
			//select from entity manager
			Professor pro = entityManager.find(Professor.class, id);
			
			//delete
			entityManager.remove(pro);
			
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

	public void searchProfessor() {

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
			System.out.println("Enter Professor Id : ");
			int id = Integer.parseInt(input.nextLine());
			
			//select from entity manager
			Professor pro = entityManager.find(Professor.class, id);
			
			
			
			//printing professor info
			System.out.println("Professor ID : "+pro.getProfessorId());
			System.out.println("Professor First Name : "+pro.getFirstName());
			System.out.println("Professor Last Name : "+pro.getLastName());
			System.out.println("Professor Department No. : "+pro.getDeptNo());
			System.out.println("Professor Salary : "+pro.getSalary());
			System.out.println("Professor Joining Date : "+pro.getJoinDate());
			System.out.println("Professor Date of Birth : "+pro.getDateOfBirth());
			System.out.println("Professor Gender : "+pro.getGender());
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			emf.close();
		}
		
		
	}

	public void searchProfessorByName() {
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
			System.out.println("Enter Professor Name : ");
			String searchingName= input.nextLine();
			
			//select from entity manager
			Professor pro = (Professor) entityManager.createQuery("SELECT p FROM Professor p WHERE p.firstName =: name",Professor.class).setParameter("firstname", searchingName).getSingleResult();
			
			
			
			//printing professor info
			System.out.println("Professor ID : "+pro.getProfessorId());
			System.out.println("Professor First Name : "+pro.getFirstName());
			System.out.println("Professor Last Name : "+pro.getLastName());
			System.out.println("Professor Department No. : "+pro.getDeptNo());
			System.out.println("Professor Salary : "+pro.getSalary());
			System.out.println("Professor Joining Date : "+pro.getJoinDate());
			System.out.println("Professor Date of Birth : "+pro.getDateOfBirth());
			System.out.println("Professor Gender : "+pro.getGender());
			

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
