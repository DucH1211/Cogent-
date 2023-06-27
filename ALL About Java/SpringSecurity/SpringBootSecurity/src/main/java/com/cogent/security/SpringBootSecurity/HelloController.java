package com.cogent.security.SpringBootSecurity;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String home() {
		return "Home";
	}
	@RequestMapping(value="/add/{name}")
	public String test(@PathVariable String name) throws IOException{
		return "Hello "+name;
	}
	@GetMapping("/greet")
	public String greet()
	{
		return "Greetings";
	}
}
