package com.springboot.conversion.AssignmentSpringBoot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.conversion.AssignmentSpringBoot.entity.Student;
import com.springboot.conversion.AssignmentSpringBoot.service.StudentDAOService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api")
public class StudentRestController {
	@Autowired
	StudentDAOService service;
	
	@GetMapping("/hello")
	public String helloStudent() 
	{
		return "Hello Students!!";
	}
	
	@PostMapping("/add-student")
	public ResponseEntity<Object> addStudent(@RequestBody Student thestudent)
	{
		try
		{
			service.createStudent(thestudent); 
			System.out.println("Student Created");
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Student not created!");
		}
		return null;
		
	}
	@GetMapping("/get-student")
	public List<Student> getStudent(){
//		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		List<Student> theStudents = service.getAllStudents();
//		return new ResponseEntity<List>(theStudents,headers,HttpStatus.CREATED);
		return theStudents;
	}
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable int id)
	{
		try {
			service.deleteStudent(id);
			System.out.println("Student at ID:" + id +" Deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Student not deleted!");
		}
		return null;
	}
}
