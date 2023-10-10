package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BaseEmailContentDto;
import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.Message;
import com.cvillegas.app.main.service.IEmailService;
import com.cvillegas.app.main.utils.IPIdentifierHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
@Slf4j
@AllArgsConstructor
public class EmailSenderController {
    private IEmailService emailService;

    @PostMapping("/sendBasicEmail")
    public BasicResponseDto sendBasicEmail(HttpServletRequest servletRequest, @RequestBody BaseEmailContentDto emailContent){
        String clientIp = servletRequest.getRemoteAddr();
        log.info(clientIp);
        return emailService.sendSimpleMessage(emailContent);
    }

    @PostMapping("/sendEmail")
    public BasicResponseDto sendEmail(HttpServletRequest servletRequest, @RequestBody BaseEmailContentDto emailContent){
        String clientIp = servletRequest.getRemoteAddr();
        log.info(clientIp);
        return emailService.sendSimpleMessage(emailContent);
    }
}
