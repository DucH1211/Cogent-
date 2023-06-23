package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
@Autowired
EmployeeRepository emprepos;
	

	@Override
	public int saveEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		if(emprepos.save(emp)!=null)
			return 1;
		else return 0;
	}

	@Override
	public int updateUser(Employee emp, int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteEmployee(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
