package com.example.emaildemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail(String to, String subject,String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("********@qq.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setCc("********@qq.com");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
    }
}