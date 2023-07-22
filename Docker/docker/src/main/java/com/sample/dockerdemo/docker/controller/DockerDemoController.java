package com.sample.dockerdemo.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerDemoController {
	@GetMapping("/home")
	public String home()
	{
		return "Hello from Docker";
	}
}
