package com.cogetn.springjpa.SpringJPATest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JPARestController {
	@Autowired EmployeeDAO eDAO;
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee e1) throws Exception
	{
		if(eDAO.saveEmployee(e1) > 0)
			return "Employee created";
		else return "Employee not created";
	}
}
