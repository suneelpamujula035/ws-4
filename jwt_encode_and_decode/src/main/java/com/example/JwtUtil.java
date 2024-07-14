package com.example;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	// To generate JWT token
	public static String generateJwtToken(String subject, String secretKey) {
		return Jwts.builder().setId("tk9931").setSubject(subject).setIssuer("ABC_LTD").setAudience("XYZ_ltd")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)))
				.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secretKey.getBytes())).compact();
	}

	// To claim JWT token
	public static Claims getClaims(String token, String secretKey) {
		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(secretKey.getBytes())).parseClaimsJws(token)
				.getBody();
	}
}
