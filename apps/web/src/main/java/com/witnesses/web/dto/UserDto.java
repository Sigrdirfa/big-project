package com.witnesses.web.dto;

import com.witnesses.web.constant.Role;

public record UserDto(
        String id,

        String firstName,

        String lastName,

        String email,

        Role role
) {
}
