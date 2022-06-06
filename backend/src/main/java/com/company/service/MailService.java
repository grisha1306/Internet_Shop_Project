package com.company.service;


import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@PropertySource(value = "classpath:application.properties")
public class MailService{

//    @Value("${spring.mail.host}")
//    private String host;
//
//    @Value("${spring.mail.username}")
//    private String username;
//
//    @Value("${spring.mail.password}")
//    private String password;
//
//    @Value("${spring.mail.port}")
//    private int port;
//
//    @Value("${spring.mail.protocol}")
//    private String protocol;
//
//    @Value("${mail.debug}")
//    private String debug;

    public void send(String emailTo, String subject, String message) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.yandex.ru");
        mailSender.setPort(465);
        mailSender.setUsername("grigoriy.shumilov130696@yandex.ru");
        mailSender.setPassword("jgevlvrlrgyilwtp");

        Properties properties = mailSender.getJavaMailProperties();
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");//Enable tls session
        properties.setProperty("mail.smtp.auth", "true");//Enable authentication
        properties.setProperty("mail.transport.potocol", "smtps");
        properties.setProperty("mail.debug", "true");

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("grigoriy.shumilov130696@yandex.ru");
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }

}
