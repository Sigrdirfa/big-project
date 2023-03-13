package com.witnesses.web.dto;

import lombok.*;

@Builder
public record AuthenticationRequest(
        String email,
        String password
) {
}
