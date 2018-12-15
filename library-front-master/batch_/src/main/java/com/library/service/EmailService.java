package com.library.service;

import com.library.config.JavaMailSenderUtil;
import org.springframework.mail.SimpleMailMessage;

import static com.library.config.JavaMailSenderConfig.getJavaMailSender;


public class EmailService extends JavaMailSenderUtil {
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        getJavaMailSender().send(message);
    }
}
