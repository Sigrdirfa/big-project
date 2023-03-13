package com.witnesses.bigproject.dto;

import lombok.*;

@Builder
public record AuthenticationResponse(
        String token
) {
}
