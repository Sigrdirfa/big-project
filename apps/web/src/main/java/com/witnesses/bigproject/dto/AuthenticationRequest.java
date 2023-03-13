package com.witnesses.bigproject.dto;

import lombok.*;

@Builder
public record AuthenticationRequest(
        String email,
        String password
) {
}
