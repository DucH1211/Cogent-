package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeDAO {
	public int saveEmployee(Employee emp)throws Exception;
	public int updateUser(Employee emp,int id)throws Exception;
	public boolean deleteEmployee(int id)throws Exception;
	public List<Employee> findAll()throws Exception;

}
