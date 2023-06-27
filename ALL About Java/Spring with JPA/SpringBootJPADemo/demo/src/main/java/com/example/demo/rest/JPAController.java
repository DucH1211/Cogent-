package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Employee;
import com.example.demo.common.EmployeeDAO;


@RestController
public class JPAController {
	@Autowired
	EmployeeDAO empDao;
	
	@PostMapping
	public String addEmployee(@ModelAttribute Employee E) throws Exception {
		if(empDao.saveEmployee(E) > 0)
			return "Employee created";
		return "Employee not created";
	}
}
