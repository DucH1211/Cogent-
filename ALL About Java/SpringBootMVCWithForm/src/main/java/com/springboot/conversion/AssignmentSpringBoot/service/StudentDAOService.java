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
	
	/**
	 * Student Service method to create a new Student with given input
	 * Student is saved into database.
	 * @return 
	 */
	public boolean createStudent(Student theStudent) {
		System.out.println("Creating new Student");
		System.out.println("Saving the Student");
		if(studentDAO.save(theStudent))
		{
			System.out.println("Saved Student: " + theStudent);
			return true;
		}
		else return false;
		
		
	}
	
	/**
	 * A testing method to insert multiple students for testing purpose
	 */
	public void createMultipleStudent() {
//		System.out.println("Creating new Students");
//		Student tempStudent = new Student("Duke", "Ho2","duch.student@cogent.com");
//		Student tempStudent1 = new Student("Duke2", "Ho1","duch1.student@cogent.com");
//		Student tempStudent2 = new Student("Duke3", "Ho5","duch2.student@cogent.com");
//		Student tempStudent3 = new Student("Duke1", "Ho3","duch3.student@cogent.com");
//		System.out.println("Saving the Students.....");
//		studentDAO.save(tempStudent);
//		System.out.println("Saved Student: " + tempStudent);
//		studentDAO.save(tempStudent1);
//		System.out.println("Saved Student: " + tempStudent1);
//		studentDAO.save(tempStudent2);
//		System.out.println("Saved Student: " + tempStudent2);
//		studentDAO.save(tempStudent3);
//		System.out.println("Saved Student: " + tempStudent3);
	}
	
	/**
	 * print out student with given id
	 * @param id
	 * @return {@link String} of the Student Found.
	 */
	public String readStudent(int id) {
		System.out.println("Student with id :" + id + " info:");
		Student myStudent = studentDAO.findById(id);
		return myStudent.toString();
		
	}
	
	/**
	 * updating student with given id.
	 * @param id
	 */
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
	
	public List<Student> getStudentsByLastName(String LastName) {
		List<Student> theStudents = studentDAO.findByLastName(LastName);
		System.out.println("List of Students with LastName: "
				+ LastName);
		theStudents.stream().forEach(x->System.out.println(x));
		return theStudents;
		
	}

}
