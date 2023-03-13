package com.witnesses.web.dto;

import lombok.*;

@Builder
public record AuthenticationResponse(
        String token
) {
}
