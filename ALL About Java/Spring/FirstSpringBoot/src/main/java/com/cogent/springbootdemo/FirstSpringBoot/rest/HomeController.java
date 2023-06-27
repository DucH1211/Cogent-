package com.cogent.springbootdemo.FirstSpringBoot.rest;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.springbootdemo.FirstSpringBoot.common.User;


@RestController
public class HomeController {
	ArrayList<User> userlist = new ArrayList<>();
	@RequestMapping("/{name}")
	public String test(@PathVariable String name) {
		return "Hello " + name;
	}
	@PostMapping(value = "/addUser") //receive data from other end to this end
	public String addUser(@ModelAttribute User user1)
	{
		userlist.add(user1);
		return userlist.size() + " User Inserted";
		
	}
	@GetMapping("/getUsers") //get data from this end to display to other end 
		public ArrayList<User> getUsers()
		{
			return userlist;//GetMapping return object is converted to JSON format
		}
}
