package com.cogent.security.SpringBootSecurity.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSetBasedJWKSource;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JWTAuthentication {
	@Autowired
	DataSource dataSource;
	
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
		http.oauth2ResourceServer(oath -> oath.jwt());
		
		return http.build();
	}
	/**
	 * this function generates a keypair using {@link KeyPairGenerator}
	 * with .getInstance and .initialize(2048) 
	 * //2048 is size of the key
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@Bean
	public KeyPair generateKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		return keyPairGenerator.generateKeyPair();
	}
	/**
	 * creating an RSAkey with Builder class, 
	 * building RSAKey object with {@link RSAPublicKey}, 
	 * privateKey from {@link KeyPair}
	 * and random keyID with {@link UUID} randomUUID().toString() method.
	 * @param keyPair
	 * @return {@link RSAKey}
	 */
	@Bean 
	RSAKey rsaKey(KeyPair keyPair)
	{
		return new RSAKey
				.Builder((RSAPublicKey)keyPair.getPublic())
				.privateKey(keyPair.getPrivate())
				.keyID(UUID.randomUUID().toString())
				.build();
	}
	/**
	 * 
	 */
	@Bean 
	public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey){
		var jwkSet = new com.nimbusds.jose.jwk.JWKSet(rsaKey);
		
		return(JWKSelector,context) -> JWKSelector.select(jwkSet);
	}
	/**
	 * 
	 * @param rsaKey
	 * @return
	 */
	@Bean public JwtDecoder jwtDecoder(RSAKey rsaKey)
	{
		return null;
		
	}
	@Bean
	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource)
	{
		return new NimbusJwtEncoder(jwkSource);
	}
}
