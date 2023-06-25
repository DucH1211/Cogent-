package com.cogent.security.SpringBootSecurity;

import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/add/{name}")
	public String test(@PathVariable String name) throws IOException{
		return "Hello "+name;
		
	}
	
}
