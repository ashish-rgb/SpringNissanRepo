package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.Employee;

public interface IEmployeeRepository extends JpaRepositoryImplementation<Employee, Integer>{

	// Spring data JPA -- JPARepositoryImplementation , CrudRepository

		
		//Custom Retrieve Phone
		@Query("from Employee where phone=?1")
		public Employee searchByPhone(int phone);
	
}
