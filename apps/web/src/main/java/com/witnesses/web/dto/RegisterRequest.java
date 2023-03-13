package com.witnesses.web.dto;

import lombok.*;


@Builder
public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
