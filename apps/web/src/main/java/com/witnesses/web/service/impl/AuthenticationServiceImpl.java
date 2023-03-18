package com.witnesses.web.service.impl;

import com.witnesses.web.constant.Role;
import com.witnesses.web.dto.*;
import com.witnesses.web.entity.ConfirmToken;
import com.witnesses.web.entity.User;
import com.witnesses.web.repository.ConfirmTokenRepository;
import com.witnesses.web.repository.UserRepository;
import com.witnesses.web.service.AuthenticationService;
import com.witnesses.web.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final ConfirmTokenRepository confirmTokenRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        List<String> tokens = checkDuplicateUserEmail(request.email());
        if(!CollectionUtils.isEmpty(tokens)) {
            return AuthenticationResponse.builder()
                    .token(tokens.get(0))
                    .build();
        }

        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .passWord(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        //The first batch uses a database to store token information, and should be replaced by an in-memory database in the future
        confirmTokenRepository.save(
                ConfirmToken.builder()
                        .token(token)
                        .user(user)
                        .build());
        //todo: send email to enable user

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    private List<String> checkDuplicateUserEmail(String email) {
        List<String> tokens = new ArrayList<>();
        userRepository.findByEmail(email).ifPresent(user -> {
            if (user.getEnabled()) {
                throw new IllegalArgumentException("User already exists");
            } else {
                tokens.add(jwtService.generateToken(user));
                confirmTokenRepository.findByUser(user.getId()).ifPresent(confirmToken -> {
                    confirmToken.setToken(tokens.get(0));
                    confirmTokenRepository.saveAndFlush(confirmToken);
                });
                //todo: send email to enable user
            }
        });
        return tokens;
    }

    @Override
    public String confirm(String token) {
        confirmTokenRepository.findByToken(token).orElseThrow();
        return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.email()).orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest request) {
        return null;
    }

    @Override
    public void signOut(SignOutRequest request) {
    }


}