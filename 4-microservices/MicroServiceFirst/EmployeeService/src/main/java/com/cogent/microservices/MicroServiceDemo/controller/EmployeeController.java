package com.cogent.microservices.MicroServiceDemo.controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.microservices.MicroServiceDemo.entity.Employee;
import com.cogent.microservices.MicroServiceDemo.for_dto.Department;
import com.cogent.microservices.MicroServiceDemo.for_dto.EmployeeDepartmentResponse;
import com.cogent.microservices.MicroServiceDemo.service.EmployeeService;
/**
 * Employee Controller, used to declare endpoints for request and responses
 * with a base url.
 * @author tmyho
 *
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmployeeService dept_service;
	/**
	 * Test connectivity to the port.
	 * @return
	 */
	@GetMapping("/test")
	public String employeeWorks(){
		return "<h1>This Employee Link Works</h1>";
	}
	/**
	 * Endpoint that will return list of Employee as a Json Object
	 * @return {@link List}{@link Employee}
	 */
	@GetMapping
	public List<Employee> getAllemployee()
	{
		List<Employee> result = dept_service.getAllEmployee();
		System.out.println(result);
		return result;
	}
	/**
	 * This Endpoint return one {@link Employee} with given {@link PathVariable} id
	 * @param id
	 * @return {@link Optional} {@link Employee}
	 */
	@GetMapping("/{id}")
	public Optional<Employee> getemployee_Id(@PathVariable("id") int id) {
		return dept_service.getEmployeebyId(id);
	}
	/**
	 * This Endpoint return a {@link ResponseEntity} with only {@link HttpStatus}
	 * This Endpoint will save an Employee to Inmemmory Database with {@link JpaRepository} extentions
	 * @param theEmployee
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee theEmployee)
	{
		try {
			dept_service.saveEmployee(theEmployee);
			System.out.println(theEmployee);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.noContent().build();
		}
	}
	/**
	 * Takes in employee_id and return a department associated with it.
	 * @param emp_id
	 * @return
	 */
	@GetMapping("/{id}/department")
	public ResponseEntity getDepartment(@PathVariable("id") int id)
	{
		LOGGER.info("{}",id);
		try {
			EmployeeDepartmentResponse ed_Response= dept_service.getEmployeeDepartment(id);
			if(ed_Response.getDepartment() == null)
				throw new NullPointerException();
			return ResponseEntity.ok(ed_Response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.ok("Department of employee id: "+id+" not Found. Will be later handle with a view here.");
		}
	}
}
