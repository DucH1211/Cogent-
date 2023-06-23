package com.example.demo.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
	public int saveEmployee(Employee Employee) throws Exception;
	public int updateUser(Employee emp, int id);
	public boolean deleteEmployee(int id);
	public List<Employee> findAll();
	
}
