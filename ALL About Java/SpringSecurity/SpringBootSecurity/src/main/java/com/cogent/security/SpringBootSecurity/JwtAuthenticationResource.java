package com.cogent.security.SpringBootSecurity;

import java.time.Instant;
import java.util.stream.Collectors;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jwt.JWTClaimsSet;

@RestController
public class JwtAuthenticationResource {
	
	private JwtEncoder jwtEncoder;
	
	public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}
	
	@PostMapping("/authenticate")
	public JwtRespond authenticate(Authentication authentication)
	{
		return new JwtRespond(createToken(authentication));
	}
	
	private String createToken(Authentication authentication) {
		var claims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(Instant.now())
				.expiresAt(Instant.now().plusSeconds(60*60))
				.subject(authentication.getName())
				.claim("scope", createScope(authentication))
				.build();
		return jwtEncoder.encode(JwtEncoderParameters.from((JwtClaimsSet) claims))
				.getTokenValue();
	}
	private String createScope(Authentication authentication)
	{
		return authentication.getAuthorities().stream()
				.map(a-> a.getAuthority())
				.collect(Collectors.joining(" "));
	}
}

record JwtRespond(String token) {}