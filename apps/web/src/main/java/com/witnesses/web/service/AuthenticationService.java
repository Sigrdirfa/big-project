package com.witnesses.web.service;

import com.witnesses.web.dto.*;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    String confirm(String token);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void signOut(SignOutRequest request);


}
