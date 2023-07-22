package com.cogent.microservices.MicroServiceDemo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cogent.microservices.MicroServiceDemo.for_dto.Department;


@FeignClient(name="departmentservice",path="api/departments")
public interface DepartmentServiceProxy {
	@GetMapping("/test")
	public String departmentWorks();
	@GetMapping
	public List<Department> getAllDepartment();
	@GetMapping("/{id}")
	public Optional<Department> getDepartment_Id(@PathVariable("id") int id);
	@PostMapping
	public ResponseEntity<Object> addDeparment(@RequestBody Department theDepartment);

}
