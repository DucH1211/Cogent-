package com.cogent.microservices.MicroServiceDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import lombok.AllArgsConstructor;//lombok is devtool
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link Entity} class for department with id, name and address.
 * {@link NoArgsConstructor}, {@link AllArgsConstructor}, {@link Data}
 * @author tmyho
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int department_id;
	private String department_name;
	private String department_address;
	
	
}
