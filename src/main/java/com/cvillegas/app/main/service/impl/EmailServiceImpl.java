package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.BaseEmailContentDto;
import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.service.IEmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class EmailServiceImpl implements IEmailService {
    private JavaMailSender mailSender;

    @Override
    public BasicResponseDto sendSimpleMessage(BaseEmailContentDto emailContent) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("notif9692@gmail.com");
            message.setTo("cristianvg9692@gmail.com");
            message.setSubject(emailContent.getSubject());
            message.setText(emailContent.getText());
            log.info( "Sending {}", message.toString() );
            mailSender.send( message );
            log.info("Sent message...");

            return new BasicResponseDto( HttpStatus.OK, "Message was sent" );
        } catch(Exception e) {
            return new BasicResponseDto( HttpStatus.BAD_REQUEST, "Message was not sent" );
        }
    }

    @Override
    public void sendCustomMessage(String to, String subject, String text) {
        throw new RuntimeException("Not defined");
    }
}
