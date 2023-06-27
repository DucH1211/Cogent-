package com.cogetn.springjpa.SpringJPATest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTestApplication.class, args);
	}

}
