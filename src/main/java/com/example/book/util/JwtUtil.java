package com.example.book.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

//    private final String SECRET = "mysecretkeymysecretkeymysecretkey123"; // should be 32+ chars
//    private final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    //private String secret = "my_secret_key_12345";

    @Value("${jwt.secret}")
    private String secret;

//    private Key getKey() {
//        return Keys.hmacShaKeyFor(SECRET.getBytes());
//    }

//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }

    public SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignInKey())
                .parseClaimsJws(token)
                .getBody();
    }

//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
}