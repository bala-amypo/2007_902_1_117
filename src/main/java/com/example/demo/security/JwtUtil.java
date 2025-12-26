package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Use a strong 256-bit key
    private static final String SECRET_KEY = "THIS_IS_A_SECURE_SECRET_KEY_FOR_JWT_256_BITS_1234567890";

    // Token validity: 1 hour
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    // Get signing key from secret
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Generate JWT token for a username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract expiration date from token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract any claim using claimsResolver function
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    // Check if token is expired
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Validate token: check username and expiration
    public boolean validateToken(String token, String username) {
        final String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }
}
