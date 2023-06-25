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

@SpringBootApplication
@EnableAutoConfiguration
public class AssignmentSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AssignmentSpringBootApplication.class, args);
	}
	@Autowired
	private StudentDAO studentDAO;

	
	@Override
	public void run(String... args) throws Exception {
		 
		System.out.println("Hello World");
		createStudent(studentDAO);
	}
	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student");
		Student tempStudent = new Student("Duke", "Ho","duch.student@cogent.com");
		
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);
		System.out.println("Saved Student: " + tempStudent);
	}
}
