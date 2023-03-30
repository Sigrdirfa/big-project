package com.witnesses.web.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public interface JwtService {
    /**
     * Extract user email from jwt
     */
    String extractUserEmail(String jwt);

    /**
     * Extract all claims from jwt
     */
    <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver);

    /**
     * Generate token with extra claims
     */
    String generateToken(Map<String, Objects> extraClaims, UserDetails userDetails);

    /**
     * Generate token without extra claims
     */
    String generateToken(UserDetails userDetails);

    /**
     * Check if token is expired
     */
    boolean isTokenValidate(String token, UserDetails userDetails);

}
