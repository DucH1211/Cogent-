package com.cogent.springbootdemo.FirstSpringBoot.common;

import org.springframework.stereotype.Component;

@Component
public class User { //this is a model
	private int id;
	private String username;
	private int age;
	private String email;
	

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
