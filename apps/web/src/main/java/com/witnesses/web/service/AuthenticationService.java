package com.witnesses.web.service;

import com.witnesses.web.dto.*;

public interface AuthenticationService {
    /**
     * Register a new user
     */
    AuthenticationResponse register(RegisterRequest request);

    /**
     * Confirm a user
     */
    String confirm(String token);

    /**
     * Authenticate a user
     */
    AuthenticationResponse authenticate(AuthenticationRequest request);

    /**
     * Sign out a user
     */
    void signOut(SignOutRequest request);


}
