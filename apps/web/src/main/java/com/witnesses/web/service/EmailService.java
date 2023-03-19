package com.witnesses.web.service;

public interface EmailService {
    void sendEmail(String email, String token);

    String buildEmail(String name, String link);
}
