package com.microservice.eurekaclient.employeeservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.eurekaclient.employeeservice.dto.Department;
//url = "${departmentservice_HOST:http://localhost}:9001"
//url = "http://34.29.206.142:9001"
@FeignClient(name="departmentservice",path = "api/departments",url = "http://departmentservice_service:9001")
public interface DepartmentServiceProxy {
	@GetMapping("/test")
	public String departmentWorks();
	@GetMapping
	public List<Department> getAllDepartment();
	@GetMapping("{id}")
	public Optional<Department> getDepartment_Id(@PathVariable("id") int id);
	@PostMapping
	public ResponseEntity<Object> addDeparment(@RequestBody Department theDepartment);
}
