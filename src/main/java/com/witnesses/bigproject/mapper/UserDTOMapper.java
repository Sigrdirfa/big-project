package com.witnesses.bigproject.mapper;

import com.witnesses.bigproject.dto.UserDTO;
import com.witnesses.bigproject.pojo.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return null;
    }
}
