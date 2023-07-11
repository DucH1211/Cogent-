package com.springboot.conversion.AssignmentSpringBoot.rest;

import java.util.List;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.conversion.AssignmentSpringBoot.entity.Student;
import com.springboot.conversion.AssignmentSpringBoot.service.StudentDAOService;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentDAOService service;
	
	@GetMapping("")
	public String helloStudent() 
	{
		return "studentIndex";
	}
	/**
	 * url: /student/getStudent
	 * @return {@link ModelAndView} 
	 * view from: StudentForm.jsp
	 */
	@GetMapping("/studentForm")
	public ModelAndView loadStudent(){
		return new ModelAndView("StudentForm");
	}
	
	/**
	 * url: /student/addStudent
	 * @param student
	 * @return {@link View}: studentIndex.jsp
	 */
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@ModelAttribute Student student)
	{
		if(service.createStudent(student))
			return ResponseEntity.ok("Success");
		return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	/**
	 * url: /student/loadStudent
	 * @return {@link ModelAndView} {@link View}: displayDataBase 
	 * {@link ModelMap}: {@link List}student
	 */
	@GetMapping("/loadStudent")
	public ModelAndView getAllStudent()
	{
		List<Student> students = service.getAllStudents();
		ModelAndView modelview = new ModelAndView("displayDatabase");
		modelview.addObject("students",students);
		return modelview;
	}
	/**
	 * url:/student/editStudent
	 */
//	@PostMapping("/editStudent/{id}")
//	public ModelAndView editStudent(@PathVariable int id)
//	{
//		
//		return new ModelAndView("editStudentForm/{id}");
//		
//	}
	
}
