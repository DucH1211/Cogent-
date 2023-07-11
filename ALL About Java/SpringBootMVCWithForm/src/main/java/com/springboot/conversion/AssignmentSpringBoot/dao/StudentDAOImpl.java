package com.springboot.conversion.AssignmentSpringBoot.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.conversion.AssignmentSpringBoot.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	//inject entity manager
	@Autowired
	EntityManager entityManager; 
	
	
	@Override
	@Transactional
	public boolean save(Student theStudent) { //this transaction will not create the table for you
		// TODO Auto-generated method stub
		try{entityManager.persist(theStudent);}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}


	@Override
	@Transactional
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}


	@Override
	@Transactional
	public Student update(Integer id) {
		// TODO Auto-generated method stub
		Student student = entityManager.find(Student.class, id);
		return entityManager.merge(student);
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}


	@Override
	@Transactional
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = entityManager.createQuery(
				"FROM Student WHERE lastName=:theData",Student.class); //named parameter are prefixed with a colon
		theQuery.setParameter("theData", lastName);
		return theQuery.getResultList();
	}


//	@Override
//	@Transactional
//	public int updateLastNameatId(String lastName, int id) {
//		TypedQuery<Student> theQuery = entityManager.createQuery(
//				"UPDATE Student SET lastName=:lastName",Student.class);
//		theQuery.setParameter("lastName", lastName);
////		theQuery.setParameter("id", id);
//		int rowsUpdated = theQuery.executeUpdate();
//		return rowsUpdated;
//	}

}
