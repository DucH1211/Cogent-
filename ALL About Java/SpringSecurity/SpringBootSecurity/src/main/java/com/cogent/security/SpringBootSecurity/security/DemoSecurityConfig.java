package com.cogent.security.SpringBootSecurity.security;


import java.net.http.HttpRequest;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class DemoSecurityConfig {
	/**
	 * Autowired Datasource from mysql driver
	 */
	@Autowired
	DataSource dataSource;
	
	@Autowired 
	BCryptPasswordEncoder encoder; 
	
	/**
	 * take {@link DataSource} as parameter.
	 * this method shows example of using {@link BCryptPasswordEncoder} as a bean, 
	 * and as a new {@link Object}.
	 * this method shows example of using {@link UserBuilder} as {@link User}.builder()
	 * and {@link UserDetails} as {@link UserBuilder}.build
	 * @return {@link JdbcUserDetailsManager} as a {@link UserDetailsService}
	 * 
	 */
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) { 
		UserDetails user = User.withUsername("Chandra")
				.password(encoder.encode("chandra@123"))
				.roles("USER")
				.build();
		
		UserDetails user1 = User.withUsername("Mahesh")
				.password(new BCryptPasswordEncoder().encode("mahesh@123"))
				.roles("ADMIN")
				.build();
		JdbcUserDetailsManager jdbcUserDetailManager = new JdbcUserDetailsManager(dataSource);
		if(!jdbcUserDetailManager.userExists(user.getUsername()))
			jdbcUserDetailManager.createUser(user);
		else
			jdbcUserDetailManager.updateUser(user);
		
		if(!jdbcUserDetailManager.userExists(user1.getUsername()))
			jdbcUserDetailManager.createUser(user1);
		else
			jdbcUserDetailManager.updateUser(user1);
		
		return jdbcUserDetailManager;
	}
	
	/**
	 * this method takes in {@link HttpSecurity} http.
	 * this method uses http.authorizeHttpRequests 
	 * you can use enable httpBasic, or disable csrf here
	 * or enable form login here
	 * @return {@link SecurityFilterChain}
	 * 
	 * */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth -> {
			auth
			.requestMatchers("/").hasAnyRole("USER","ADMIN")
			.requestMatchers("/add/{name}").hasAuthority("ADMIN")
			.requestMatchers("/greet").hasAuthority("ADMIN")
			.anyRequest().authenticated();
		});
		
//		use HTTP basic authentication
		http.httpBasic(Customizer.withDefaults());
		http.formLogin();
//		http.csrf(csrf -> csrf.disable()); //disable CrossSiteRequestForgery(CSRF)
											//generally not required for stateless REST API
		return http.build();
	}
	
	/**
	 * public InMemoryUserDetailsManager userDetailManager()
	 * @return {@link InMemoryUserDetailsManager} of the built {@link UserDetails} 
	 * with {@link User} .builder() method
	 * 
	 * {@link InMemoryUserDetailsManager} is a type of {@link UserDetailsService} and 
	 * {@link UserDetailsPasswordService} 
	 * mainly made for testing purpose, 
	 * another way of adding {@link UserDetails} to {@link InMemoryUserDetailsManager}
	 * */
//	@Bean
//	public InMemoryUserDetailsManager userDetailManager() { 
//		UserDetails Chicken = User.builder()
//				.username("chicken")
//				.password("{noop}test123")
//				.roles("EMPLOYEE")
//				.build();
//		
//		UserDetails Duck = User.builder()
//				.username("duck")
//				.password("{noop}duck123")
//				.roles("EMPLOYEE","MANAGER")
//				.build();
//		UserDetails Goose = User.builder()
//				.username("goose")
//				.password("{noop}gosse123")
//				.roles("EMPLOYEE","MANAGER","ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(Chicken,Duck,Goose);
//	}
	
	/**
	 * public UserDetailsService userDetailsService()
	 * {@link UserDetailsService} is a higher hierarchy Interface 
	 * of {@link InMemoryUserDetailsManager}
	 * returning {@link UserDetailsService} type is more handy
	 * @return {@link InMemoryUserDetailsManager}
	 * */
//	@Bean
//	public UserDetailsService userDetailsService() { 
//		UserDetails user = User.withUsername("Chandra")
//				.password("{noop}chandra@123")
//				.roles("USER")
//				.build();
//		
//		UserDetails user1 = User.withUsername("Mahesh")
//				.password("{noop}mahesh@123")
//				.roles("USER","MANAGER")
//				.build();
//		return new InMemoryUserDetailsManager(user1, user);
//	}
	
	
	

}
