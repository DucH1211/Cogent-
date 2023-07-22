package com.cogent.microservices.MicroServiceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients("com.cogent.microservices.MicroServiceDemo")
public class MicroServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceDemoApplication.class, args);
	}

}
