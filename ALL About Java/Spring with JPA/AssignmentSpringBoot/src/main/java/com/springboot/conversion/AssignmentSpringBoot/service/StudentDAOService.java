package com.springboot.conversion.AssignmentSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.conversion.AssignmentSpringBoot.dao.StudentDAO;
import com.springboot.conversion.AssignmentSpringBoot.entity.Student;

@Service
public class StudentDAOService {
	@Autowired
	private StudentDAO studentDAO;
	
	public void createStudent() {
		System.out.println("Creating new Student");
		Student tempStudent = new Student("Duke", "Ho","duch.student@cogent.com");
		
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);
		System.out.println("Saved Student: " + tempStudent);
	}
	
	public void createMultipleStudent() {
		System.out.println("Creating new Student");
		Student tempStudent = new Student("Duke", "Ho2","duch.student@cogent.com");
		Student tempStudent1 = new Student("Duke2", "Ho1","duch1.student@cogent.com");
		Student tempStudent2 = new Student("Duke3", "Ho5","duch2.student@cogent.com");
		Student tempStudent3 = new Student("Duke1", "Ho3","duch3.student@cogent.com");
		System.out.println("Saving the Student.....");
		studentDAO.save(tempStudent);
		System.out.println("Saved Student: " + tempStudent);
		studentDAO.save(tempStudent1);
		System.out.println("Saved Student: " + tempStudent1);
		studentDAO.save(tempStudent2);
		System.out.println("Saved Student: " + tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("Saved Student: " + tempStudent3);
	}
	public void readStudent(int id) {
		System.out.println("Student with id :" + id + " info:");
		Student myStudent = studentDAO.findById(id);
		System.out.println(myStudent);
		
	}
	public void updateStudent(int id)
	{
		System.out.println("Updating Student with ID: "
						+ id);
		studentDAO.update(id);
		readStudent(id);
	}
	public void deleteStudent(int id)
	{
		System.out.println("Deleteting Student with id:"
				+ id );
		studentDAO.delete(id);
	}
	public void getAllStudents()
	{
		List<Student> theStudent = studentDAO.findAll();
		//using stream to print all students.
		theStudent.stream().forEach(x-> System.out.println(x));
	}
	public void getStudentsByLastName(String LastName) {
		List<Student> theStudents = studentDAO.findByLastName(LastName);
		System.out.println("List of Students with LastName: "
				+ LastName);
		theStudents.stream().forEach(x->System.out.println(x));
	}
//	public void updateLastNameAtId(String lastName, int id)
//	{
//		studentDAO.updateLastNameatId(lastName,id);
//		System.out.println("Updating.....");
//		studentDAO.findById(id);
//	}
}
