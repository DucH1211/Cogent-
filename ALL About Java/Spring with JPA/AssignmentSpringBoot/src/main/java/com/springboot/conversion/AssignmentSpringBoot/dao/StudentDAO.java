package com.springboot.conversion.AssignmentSpringBoot.dao;

import java.util.List;

import com.springboot.conversion.AssignmentSpringBoot.entity.Student;


public interface StudentDAO {
	void save(Student theStudent);
	Student findById(Integer id);
	Student update(Integer id);
	void delete(Integer id);
	public List<Student> findAll();
	List<Student> findByLastName(String lastName);
//	int updateLastNameatId(String lastName, int id);
	
}
