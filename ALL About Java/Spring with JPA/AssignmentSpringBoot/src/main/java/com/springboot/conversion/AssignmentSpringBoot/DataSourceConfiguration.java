package com.springboot.conversion.AssignmentSpringBoot;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.conversion.AssignmentSpringBoot.entity.Student;

@Configuration
public class DataSourceConfiguration {
	@Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
          .driverClassName("com.mysql.cj.jdbc.Driver")
          .url("jdbc:mysql://localhost:3306/javademo")
          .username("root")
          .password("TommyTmy!12016ZXC")
          .build();	
    }
	@Bean
	public Student getStudent(){
		return new Student();
	}
}
