package com.cogent.microservices.MicroServiceDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cogent.microservices.MicroServiceDemo.entity.Department;

/**
 * {@link Service}
 * Describe available Services
 * @author tmyho
 *
 */
@Service
public interface DepartmentService {
	/**
	 * get all available {@link Department}s from database
	 * @return
	 */
	public List<Department> getAllDepartment();
	/**
	 * save the {@link Department} object passed to the parameter:
	 * @param dept
	 * @return
	 */
	public Department saveDepartment(Department dept);
	/**
	 * get the {@link Department} object with the given id.
	 * @param id
	 * @return
	 */
	public Department getDepartmentbyId(int id);
}
