package com.cogent.microservices.MicroServiceDemo.for_dto;

import java.util.Optional;

import com.cogent.microservices.MicroServiceDemo.entity.Employee;

/**
 * This class is use like a Data Transfer Object
 * used to retrieve Object from a outside package project into this {@link Department} schema
 * @author tmyho
 */
public class EmployeeDepartmentResponse {
	private Employee employee;
	
	/**
	 * this department is just a structure, 
	 * not a replicated entity
	 */
	private Department department;

	public Employee getEmployee() {
		return employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setEmployee(Employee employee2) {
		// TODO Auto-generated method stub
		this.employee = employee2;
	}
	
	
}
