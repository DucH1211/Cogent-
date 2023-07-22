package com.cogent.microservices.MicroServiceDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * {@link Entity} class for department with id, name and address.
 * {@link NoArgsConstructor}, {@link AllArgsConstructor}, {@link Data}
 * @author tmyho
 *
 */
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int department_id;
	private String department_name;
	private String department_address;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int department_id, String department_name, String department_address) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_address = department_address;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_address=" + department_address + "]";
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getDepartment_address() {
		return department_address;
	}
	public void setDepartment_address(String department_address) {
		this.department_address = department_address;
	}
	
	
}
