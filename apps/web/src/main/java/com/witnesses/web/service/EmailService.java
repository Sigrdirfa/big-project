package com.witnesses.web.service;

import java.io.FileNotFoundException;

public interface EmailService {
    /**
     * Send an email
     */
    void sendEmail(String email, String token);

    /**
     * Build an email

     */
    String buildEmail(String name, String link) throws FileNotFoundException;
}
