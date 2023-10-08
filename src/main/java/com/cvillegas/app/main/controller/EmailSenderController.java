package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BaseEmailContentDto;
import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.Message;
import com.cvillegas.app.main.service.IEmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@Slf4j
@AllArgsConstructor
public class EmailSenderController {
    private IEmailService emailService;

    @PostMapping("/sendBasicEmail")
    public BasicResponseDto sendBasicEmail(@RequestBody BaseEmailContentDto emailContent){
        return emailService.sendSimpleMessage(emailContent);
    }
}
