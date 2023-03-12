package com.witnesses.bigproject.dto;

import lombok.*;


@Builder
public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
