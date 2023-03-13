package com.witnesses.web.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public interface JwtService {
    String extractUserEmail(String jwt);

    <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver);

    String generateToken(Map<String, Objects> extraClaims, UserDetails userDetails);

    String generateToken(UserDetails userDetails);

    boolean isTokenValidate(String token, UserDetails userDetails);

}
