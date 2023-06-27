package com.springboot.conversion.AssignmentSpringBoot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	@GetMapping("/hello")
	public String helloStudent() 
	{
		return "Hello Students!!";
	}
}
