package com.nissan.app;

import com.nissan.service.ProfessorServiceImpl;

public class DemoProfessorApp {

	public static void main(String[] args) {
		
		//call 
		ProfessorServiceImpl professorService = new ProfessorServiceImpl();
		
		professorService.menuDriven();

	}

}
