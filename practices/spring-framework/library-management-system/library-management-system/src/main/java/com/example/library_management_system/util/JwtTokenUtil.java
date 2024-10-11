package com.example.library_management_system.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenUtil {
    private static final String SECRET_KEY = "83588c5e1cbfb225a97497fc9d3216e02a9c75b43e8add4b6bb11be73cebe63246a35ee33239b092ccbbdc80a824c83fd8e6a9e7bb6d2f259a05e98de196d149b0d373717782bc6081553dcfe3848753f77ad86ce10430cc512b94a993c36dd05f4334578068f3500e85c8efff3a619e49c2b0361d88e1f34360c1f284befac7e52db314a2759b4cb17e8457cdea3638e053839b3de9ba37bc8d39674829f6ac0285228f327c0b7b598e56fd25298e8ebb8b24f9e3f7805e8f6e82cdce01274b0ad2d0e6f1c773c6749cca4342237599027b4536d71fcaf4015dede0d578a1708450dcffd99b942f6124f020fa2f375dfc92377b2b6623c7d5c76405732554c9";
    private static final long EXPIRATION_TIME = 86400000;

    private static Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Generate JWT Token
    public static String generateToken(String username) {
        try {
            return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
        } catch (JwtException exception) {
            throw new JwtException("Error while generating token", exception);
        }
    }

    // Validate JWT Token
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // Extract Username from JWT Token
    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
