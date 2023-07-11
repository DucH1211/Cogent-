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
	
	public void createStudent(Student thestudent) {
		System.out.println("Creating new Student");
		studentDAO.save(thestudent);//a
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
	public List<Student> getAllStudents()
	{
		List<Student> theStudents = studentDAO.findAll();
		//using stream to print all students.
		theStudents.stream().forEach(x-> System.out.println(x));
		return theStudents;
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
