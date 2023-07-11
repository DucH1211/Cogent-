package com.example.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	@Autowired
	UserDAO userDAO;
	ArrayList<User> al=new ArrayList<>();
	@RequestMapping(value="/add/{name}")
	public String test(@PathVariable String name) throws IOException{
		return "Hello"+" "+name;
		
	}
	@PostMapping(value="/addUser")
	public String create(@ModelAttribute User user1) throws IOException,Exception{
		al.add(user1);
		System.out.println(user1);
		/*if(userDAO.saveUser(user1))
			return "user inserted";
		else
			return "Not inserted";*/
		return "User Created";
	}
	@GetMapping(value="/getUsers")
	public ArrayList getUsers() throws IOException{
		return al;
	}
	
}
