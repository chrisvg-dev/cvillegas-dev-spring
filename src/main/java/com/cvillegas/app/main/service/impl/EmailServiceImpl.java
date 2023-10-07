package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.BaseEmailContentDto;
import com.cvillegas.app.main.service.IEmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class EmailServiceImpl implements IEmailService {
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(BaseEmailContentDto emailContent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailContent.getFrom());
        message.setTo(emailContent.getTo());
        message.setSubject(emailContent.getSubject());
        message.setText(emailContent.getText());
        log.info( "Sending {}", message.toString() );
        mailSender.send( message );
        log.info("Sent message...");
    }

    @Override
    public void sendCustomMessage(String to, String subject, String text) {
        throw new RuntimeException("Not defined");
    }
}
