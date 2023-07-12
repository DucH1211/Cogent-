package com.cogent.microservices.MicroServiceDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.microservices.MicroServiceDemo.entity.Department;
import com.cogent.microservices.MicroServiceDemo.repository.DepartmentRepository;
/**
 * Implementation of DepartmentService
 * @author tmyho
 *
 */
@Service
public class DeparmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository jpa_repo;
	
	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return jpa_repo.findAll();
	}

	@Override
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return jpa_repo.save(dept);
	}

	@Override
	public Optional<Department> getDepartmentbyId(int id) {
		// TODO Auto-generated method stub
		return jpa_repo.findById(id);
	}

}
