package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
@Autowired
EmployeeDAO dao;
@Autowired
UserDAO dao1;
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		EmployeeDAO emp=new EmployeeDAOImpl();
		//System.out.println(emp.saveEmployee(new Employee()));
		//UserDAORepository u=new UserDAORepository();
		//u.saveUser(new User());
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Employee emp=new Employee();
		emp.setId(5);
		emp.setEmail("aaa@gmail.com");
		emp.setName("AAA");*/
		/*User emp=new User();
		emp.setId(7);
		emp.setEmail("aaa@gmail.com");
		emp.setName("AAA");
		emp.setAge(23);
		dao1.saveUser(emp);*/
	}

}
