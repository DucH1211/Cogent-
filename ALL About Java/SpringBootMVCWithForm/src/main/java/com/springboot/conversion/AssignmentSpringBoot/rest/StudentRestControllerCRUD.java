package com.springboot.conversion.AssignmentSpringBoot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.conversion.AssignmentSpringBoot.entity.Student;
import com.springboot.conversion.AssignmentSpringBoot.service.StudentDAOService;

@RestController
@RequestMapping("/")
public class StudentRestControllerCRUD {
	@Autowired
	StudentDAOService service;
	
	@GetMapping("/")
	public String index()
	{
		return "<h1>HOME PAGE HERE</h1> <br> "
				+ "<a href = \"/student/studentForm\">Go To Student Form</a> <br>"
				+ "<a href = \"/student/loadStudent\">Display all data</a>";
	}
	
}
