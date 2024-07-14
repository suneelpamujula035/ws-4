package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.Claims;

@SpringBootApplication
public class JwtEncodeAndDecodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtEncodeAndDecodeApplication.class, args);
		String secretKey = "J@!gt*K";

		String token = JwtUtil.generateJwtToken("Token1", secretKey);
		System.out.println(token);
		System.out.println("-------------------------------------");
		Claims claims = JwtUtil.getClaims(token, secretKey);
		System.out.println("Token Id : " + claims.getId());
		System.out.println("Token Subject : " + claims.getSubject());
		System.out.println("Token Issuer : " + claims.getIssuer());
		System.out.println("Token Issue date : " + claims.getIssuedAt());
		System.out.println("Token Expiration date : " + claims.getExpiration());
		System.out.println("Token Audience : " + claims.getAudience());
	}

}
