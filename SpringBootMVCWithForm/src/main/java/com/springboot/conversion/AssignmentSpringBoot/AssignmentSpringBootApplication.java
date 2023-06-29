package com.springboot.conversion.AssignmentSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.springboot.conversion.AssignmentSpringBoot.dao.StudentDAO;
import com.springboot.conversion.AssignmentSpringBoot.entity.Student;
import com.springboot.conversion.AssignmentSpringBoot.rest.StudentController;
import com.springboot.conversion.AssignmentSpringBoot.service.StudentDAOService;

@SpringBootApplication
@EnableAutoConfiguration
public class AssignmentSpringBootApplication implements CommandLineRunner{
	@Autowired
	StudentController controller;
	
	@Autowired
	StudentDAOService service;
	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentSpringBootApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		service.createStudent(new Student("Duc","Ho","duch@gmail.com"));
		
	}
 
//		System.out.println("Hello World");
//		service.createStudent();
//		service.createMultipleStudent();
//		service.readStudent(2);
//		service.updateStudent(2);
//		service.deleteStudent(2);
//		service.getAllStudents();
//		service.getStudentsByLastName("Ho3");
//		service.updateLastNameAtId("Tom", 3);

}
