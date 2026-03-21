package com.substring.foodie.substring_foodie.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Date;

@Service
public class JwtService {
    // millseconds
    private static final long EXPIRATION_TIME = 15 * 60 * 1000; // 15 minutes
    private static final String SECRET_KEY = "this is the best token in the world";
    private static final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private Logger logger = LoggerFactory.getLogger(JwtService.class);

    // generate token
    public String generateToken(String username) {
        logger.info(key.getFormat());
        return Jwts
                .builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + JwtService.EXPIRATION_TIME))
                .signWith(key,Jwts.SIG.HS256)
                .compact();
    }
    // get username from token
    public String getUsername(String token) {
        String username = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
        return username;
    }


    //validate token
    public boolean validateToken(String token) {
        if (this.isTokenExpired(token)) {
            return false;
        }
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        }
        catch (JwtException e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean isTokenExpired(String token) {
        Date expirationTime = Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return expirationTime.before(new Date());
    }
}
