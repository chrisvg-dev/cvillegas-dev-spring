package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BaseEmailContentDto;
import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.Message;
import com.cvillegas.app.main.service.IEmailService;
import com.cvillegas.app.main.utils.IPIdentifierHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@Slf4j
public class EmailSenderController {
    private IEmailService emailService;

    @PostMapping("/apps/sendBasicEmail")
    public BasicResponseDto sendBasicEmail(HttpServletRequest servletRequest,
            @RequestBody BaseEmailContentDto emailContent) {
        String clientIp = servletRequest.getRemoteAddr();
        log.info(clientIp);
        return emailService.sendSimpleMessage(emailContent);
    }
}
