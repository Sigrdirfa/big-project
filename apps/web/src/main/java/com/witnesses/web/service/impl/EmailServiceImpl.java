package com.witnesses.web.service.impl;

import com.witnesses.web.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
//    private final JavaMailSender emailSender;

    //todo: use a message queue to send email in the future
    @Override
    @Async
    public void sendEmail(String email, String token) {
//        try {
//            MimeMessage mimeMessage = emailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, token);
//            helper.setText(token, true);
//            helper.setTo(email);
//            helper.setSubject("confirm email");
//            helper.setFrom("sigrdirfa@163.com");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public String buildEmail(String name, String link) {
        try {
            return ResourceUtils.getFile("classpath:email.html").toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
