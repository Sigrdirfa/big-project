package com.witnesses.web.controller;

import com.witnesses.web.dto.UserDto;
import com.witnesses.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(userDto));
    }
}
