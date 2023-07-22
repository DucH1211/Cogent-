package com.cogent.microservices.MicroServiceDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cogent.microservices.MicroServiceDemo.controller.DepartmentServiceProxy;
import com.cogent.microservices.MicroServiceDemo.entity.Employee;
import com.cogent.microservices.MicroServiceDemo.for_dto.Department;
import com.cogent.microservices.MicroServiceDemo.for_dto.EmployeeDepartmentResponse;
import com.cogent.microservices.MicroServiceDemo.repository.EmployeeRepository;
/**
 * Implementation of EmployeeService using {@link EmployeeRepository} {@link JpaRepository} 
 * @author tmyho
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	/**
	 * This is autoconfigured in Spring Cloud but not in SpringWeb,
	 * have to manually inject the bean in.
	 */
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private DepartmentServiceProxy departmentServiceProxy;
	@Autowired
	private EmployeeRepository jpa_repo;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return jpa_repo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee dept) {
		// TODO Auto-generated method stub
		return jpa_repo.save(dept);
	}

	@Override
	public Optional<Employee> getEmployeebyId(int id) {
		// TODO Auto-generated method stub
		return jpa_repo.findById(id);
	}
	
	/**
	 * Functionality Description:
	 * retrieve {@link Employee} object from database using findById()
	 * retrieve {@link Department} object from database using {@link RestTemplate}
	 * RestTemplate will use url and a stub class to store the retrieved {@link Department}
	 * url: "http://localhost:9001/api/departments/{id}". this url will retrieve
	 * the Department entity from the database using departmentservice
	 * 
	 */
	@Override
	public EmployeeDepartmentResponse getEmployeeDepartment(int employeeId) {
		// TODO Auto-generated method stub
		EmployeeDepartmentResponse respond_dto = new EmployeeDepartmentResponse();
		//1.Get Employee
		Employee employee = jpa_repo.findById(employeeId).get();
		//2.Get Department
		String url = "http://localhost:9001/api/departments/" + employee.getDepartment_id();
		//Department department = restTemplate.getForObject(url, Department.class);
		Department department = departmentServiceProxy.getDepartment_Id(employee.getDepartment_id()).get();
		//Goal: How to retrieve the department cordinated with 
		respond_dto.setEmployee(employee);
		respond_dto.setDepartment(department);
		return respond_dto;
	}

}
