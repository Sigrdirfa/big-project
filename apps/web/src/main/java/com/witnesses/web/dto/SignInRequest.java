package com.witnesses.web.dto;

public record SignInRequest(
        String email,
        String password
) {
}
