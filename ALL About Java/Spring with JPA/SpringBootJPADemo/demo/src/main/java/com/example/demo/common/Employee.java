package com.example.demo.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_jpa")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this will give it the pk auto-increment
	@Column(name = "emp_id")
	private int id; 
	
	@Column(name = "name")
	private String name;
	
	@Column (name = "age")
	private int age;
	
	@Column (name = "salary")
	private int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
