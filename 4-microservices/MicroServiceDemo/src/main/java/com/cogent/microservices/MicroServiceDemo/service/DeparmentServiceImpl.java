package com.cogent.microservices.MicroServiceDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cogent.microservices.MicroServiceDemo.entity.Department;
import com.cogent.microservices.MicroServiceDemo.repository.DepartmentRepository;

public class DeparmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository jpa_repo;
	
	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
