package com.cogetn.springjpa.SpringJPATest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeDAOImplement implements EmployeeDAO{
	@Autowired
	EmployeeRepository  empRepos; //this one does not have a constructor???
	
	public EmployeeDAOImplement(EmployeeRepository empRepos) {
		this.empRepos = empRepos;
	}
	
	public EmployeeDAOImplement() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public int saveEmployee(Employee Employee) throws Exception {
		if((empRepos.save(Employee))!= null)
			return 1;
		else return 0;
	}
	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		if(empRepos.existsById(id))
			{empRepos.deleteById(id);
			return true;}
		return false;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = (List<Employee>) empRepos.findAll();
		return list;
	}
	
	@Override
	public int updateEmployee(Employee emp, int id) {
		if(deleteEmployee(id)) {
			return 0;
		}
		if(empRepos.save(emp)!= null)
			return 1;
		return 0; //return 0 if id exist or employee is null;
	}


}
