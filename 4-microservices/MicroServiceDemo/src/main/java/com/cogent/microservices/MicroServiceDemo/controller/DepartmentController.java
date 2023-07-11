package com.cogent.microservices.MicroServiceDemo.controller;

import java.util.List;

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
@RequestMapping("/api/deparments")
public class DepartmentController {
	@Autowired
	private DepartmentService dept_service;
	
	@GetMapping("/getAll_department")
	public List<Department> getAllDepartment()
	{
		return dept_service.getAllDepartment();
	}
	@GetMapping("/get_deparment/{id}")
	public Department getDepartment_Id(@PathVariable("id") int id) {
		return dept_service.getDepartmentbyId(id);
	}
	@PostMapping("/add_department")
	public ResponseEntity<Object> addDeparment(@RequestBody Department theDepartment)
	{
		try {
			dept_service.saveDepartment(theDepartment);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
