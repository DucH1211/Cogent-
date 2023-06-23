package com.cogetn.springjpa.SpringJPATest;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeDAO {
	public int saveEmployee(Employee Employee) throws Exception;
	public int updateEmployee(Employee emp, int id);
	public boolean deleteEmployee(int id);
	public List<Employee> findAll();
}
