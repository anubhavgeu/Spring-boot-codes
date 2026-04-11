package com.substring.foodie.security;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

// perform operation on jwt
// create jwt
// token se jwt
// validate token
@Service
public class JwtService {
    public static final long EXPIRATION_TIME = (15*60*1000);
    private static final String SECRET = "This is the secret key of enough size";

    public String generateToken(String username) {
        return Jwts
                .builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        if(this.isTokenExpired(token)) {
            return false;
        }
        try{
            Jwts
                    .parser()
                    .setSigningKey(SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (JwtException e){
            e.printStackTrace();
            return false;
        }


    }
    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
