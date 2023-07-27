package com.microservice.eurekaclient.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservice.eurekaclient.employeeservice.dto.EmployeeDepartmentResponse;
import com.microservice.eurekaclient.employeeservice.entity.Employee;


/**
 * {@link Service}
 * Describe available Services
 * @author tmyho
 *
 */
@Service
public interface EmployeeService {
	/**
	 * get all available {@link Employee}s from database
	 * @return
	 */
	public List<Employee> getAllEmployee();
	/**
	 * save the {@link Employee} object passed to the parameter:
	 * @param dept
	 * @return
	 */
	public Employee saveEmployee(Employee dept);
	/**
	 * get the {@link Employee} object with the given id.
	 * @param id
	 * @return
	 */
	public Optional<Employee> getEmployeebyId(int id);
	/**
	 * This will return {@link EmployeeDepartmentResponse} which is an object that contain {@link Employee} and {@link Department} together
	 */
	public EmployeeDepartmentResponse getEmployeeDepartment(int employeeId);
}
