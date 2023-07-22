package com.wikimedia.kafkaproject.wikiproducer;

import com.wikimedia.kafkaproject.wikiproducer.producer.WikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WikiProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WikiProducerApplication.class, args);
	}

	@Autowired
	private WikimediaProducer wikimediaProducer;
	@Override
	public void run(String... args) throws Exception {
		wikimediaProducer.sendMessage();
	}
}
