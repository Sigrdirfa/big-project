package com.witnesses.web.service;

import com.witnesses.web.dto.UserDto;

public interface UserService {
    /**
     * Update user
     */
    UserDto update(UserDto userDto);
}
