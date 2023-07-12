package com.cogent.microservices.MicroServiceDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.microservices.MicroServiceDemo.entity.Department;
import com.cogent.microservices.MicroServiceDemo.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService dept_service;
	@GetMapping("")
	public String departmentWorks(){
		return "<h1>This Link Works</h1>";
	}
	
	@GetMapping("/departments")
	public List<Department> getAllDepartment()
	{
		List<Department> result = dept_service.getAllDepartment();
		System.out.println(result);
		return result;
	}
	@GetMapping("/departments/{id}")
	public Optional<Department> getDepartment_Id(@PathVariable("id") int id) {
		return dept_service.getDepartmentbyId(id);
	}
	@PostMapping("/departments")
	public ResponseEntity<Object> addDeparment(@RequestBody Department theDepartment)
	{
		try {
			dept_service.saveDepartment(theDepartment);
			System.out.println(theDepartment);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
