package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDAO empdao;
	@PostMapping(value="/addEmployee")
	public String addEmployee(@ModelAttribute Employee emp)throws Exception
	{
		if((empdao.saveEmployee(emp))>0)
			return "Employee created";
		else
			return "Employee not created";
					
	}

}
