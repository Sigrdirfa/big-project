package com.witnesses.bigproject.service;

import com.witnesses.bigproject.dto.AuthenticationRequest;
import com.witnesses.bigproject.dto.AuthenticationResponse;
import com.witnesses.bigproject.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
