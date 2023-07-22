package com.wikimedia.wikiconsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikiConsumerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WikiConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
