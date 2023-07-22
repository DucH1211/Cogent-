package com.cogent.microservices.MicroServiceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroServiceDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceDemoApplication.class, args);
	}
	/**
	 * Create a Bean to inject RestTemplate, 
	 * RestTemplate is not autoinject without Spring Cloud
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

