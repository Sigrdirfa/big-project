package com.witnesses.web.mapper;

import com.witnesses.web.dto.UserDto;
import com.witnesses.web.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserDTOMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return null;
    }
}
