package com.ndgroups.pillars.security;

import com.ndgroups.pillars.model.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {
    private static final long expirationTime = 1000 * 64 * 24 * 7; // for 7 days
    @Value("${auth.token.jwtSecret}")
    private String jwtSecret;

    public String generateToken(Authentication authentication){
        CustomUserDetails userPrinciple = (CustomUserDetails) authentication.getPrincipal();
        List<String> roles = userPrinciple.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return Jwts.builder()
                .subject(userPrinciple.getUsername())
                .claim("id", userPrinciple.getId())
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expirationTime))
                .signWith(generateKey())
                .compact();


    }

    private SecretKey generateKey() {
        byte[] decodedKey = Base64.getDecoder().decode(jwtSecret);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public String extractUsername(String token){
//       return extractClaim(token, Claims::getSubject);
        Claims claims = getClaims(token);
        return claims.getSubject();

    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Boolean isTokenValid(String token){
        Claims claims = getClaims(token);
         return claims.getExpiration().after(Date.from(Instant.now()));

    }



}