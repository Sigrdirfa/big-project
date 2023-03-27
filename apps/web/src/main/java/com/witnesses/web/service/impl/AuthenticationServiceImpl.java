package com.witnesses.web.service.impl;

import com.witnesses.web.constant.Role;
import com.witnesses.web.dto.AuthenticationRequest;
import com.witnesses.web.dto.AuthenticationResponse;
import com.witnesses.web.dto.RegisterRequest;
import com.witnesses.web.dto.SignOutRequest;
import com.witnesses.web.entity.ConfirmToken;
import com.witnesses.web.entity.User;
import com.witnesses.web.repository.ConfirmTokenRepository;
import com.witnesses.web.repository.UserRepository;
import com.witnesses.web.service.AuthenticationService;
import com.witnesses.web.service.EmailService;
import com.witnesses.web.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    private final EmailService emailService;

    @Override
    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        List<String> tokens = checkDuplicateUserEmail(request.email());
        if(!CollectionUtils.isEmpty(tokens)) {
            emailService.sendEmail(request.email(), emailService.buildEmail(request.lastName(), tokens.get(0)));
            String confirmationEmail = "http://localhost:8080/api/auth/confirm?token=" + tokens.get(0);
            return AuthenticationResponse.builder()
                    .token(confirmationEmail)
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
        emailService.sendEmail(request.email(), emailService.buildEmail(request.lastName(), token));
        String confirmationEmail = "http://localhost:8080/api/auth/confirm?token=" + token;
        return AuthenticationResponse.builder()
                .token(confirmationEmail)
                .build();
    }

    private List<String> checkDuplicateUserEmail(String email) {
        List<String> tokens = new ArrayList<>();
        userRepository.findByEmail(email).ifPresent(user -> {
            if (user.getEnabled()) {
                throw new IllegalArgumentException("User already exists");
            } else {
                tokens.add(jwtService.generateToken(user));
                //todo: need to check token expiration date
                confirmTokenRepository.findByUser(user).ifPresent(
                        confirmToken -> {
                            confirmToken.setToken(tokens.get(0));
                            confirmTokenRepository.save(confirmToken);
                        });
            }
        });
        return tokens;
    }

    @Override
    @Transactional
    public String confirm(String token) {
        ConfirmToken confirmToken = confirmTokenRepository.findByToken(token).orElseThrow();
        User user = confirmToken.getUser();
        user.setEnabled(true);
       //更新用户状态
        userRepository.saveAndFlush(user);
        confirmTokenRepository.delete(confirmToken);
        System.out.println("USER_ENABLE:" + userRepository.findById(user.getId()).orElseThrow().getEnabled());
        return "successfully confirmed";
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
    public void signOut(SignOutRequest request) {
        //user signout

    }


}