package com.substring.foodie.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// perform operation on jwt
// create jwt
// token se jwt
// validate token
@Service
public class JwtService {
    public static final long EXPIRATION_TIME = (15*60*1000); // for access token
    private static final long EXPIRATION_REFRESH_TIME = 24*60*60*1000; // for refresh token
    private static final String SECRET = "This is the secret key of enough size";
    private static final String TOKEN_TYPE = "Bearer ";
    private static final String REFRESH_TOKEN_TYPE = "refresh_token";
    private static final String ACCESS_TOKEN_TYPE = "access_token";

    public String generateToken(String username, boolean isAccessToken) {
        long expTime = isAccessToken ? EXPIRATION_TIME : EXPIRATION_REFRESH_TIME;
        String tokenType = isAccessToken ? ACCESS_TOKEN_TYPE : REFRESH_TOKEN_TYPE;
        return Jwts
                .builder()
                .subject(username)
                .claim("typ", tokenType)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expTime))
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

    public boolean isRefreshToken(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String tokenType = (String)claims.get("typ");
        return tokenType.equals(REFRESH_TOKEN_TYPE);
    }

    public boolean isAccessToken(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String tokenType = (String)claims.get("typ");
        return tokenType.equals(ACCESS_TOKEN_TYPE);
    }
}
