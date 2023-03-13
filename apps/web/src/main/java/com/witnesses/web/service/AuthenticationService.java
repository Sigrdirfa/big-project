package com.witnesses.web.service;

import com.witnesses.web.dto.AuthenticationRequest;
import com.witnesses.web.dto.AuthenticationResponse;
import com.witnesses.web.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
