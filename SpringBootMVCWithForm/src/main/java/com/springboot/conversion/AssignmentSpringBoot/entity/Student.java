package com.springboot.conversion.AssignmentSpringBoot.entity;

import java.sql.Date;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String Gender;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "DOB")
	private Date DOB;

	public Student() {

	}
	

	public Student(String firstName, String lastName, String email, String gender, String education, Date dOB) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Gender = gender;
		this.education = education;
		DOB = dOB;
	}



	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", Gender=" + Gender + ", education=" + education + ", DOB=" + DOB + "]";
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("Student Entity Created");
	}
}
