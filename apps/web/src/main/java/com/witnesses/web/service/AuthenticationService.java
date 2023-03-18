package com.witnesses.web.service;

import com.witnesses.web.dto.*;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse signIn(SignInRequest request);

    void signOut(SignOutRequest request);
}
