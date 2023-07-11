package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeMVCController {
	@Autowired
	EmployeeDAO empdao;
	
	@GetMapping("/EmployeeForm")
	public String loadEmployee() {
		//Render EmployeeFrom
		return "EmployeeForm";
	}
}
