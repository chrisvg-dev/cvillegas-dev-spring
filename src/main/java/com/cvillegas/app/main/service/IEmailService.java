package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.BaseEmailContentDto;
import com.cvillegas.app.main.dto.BasicResponseDto;

public interface IEmailService {

    BasicResponseDto sendSimpleMessage(BaseEmailContentDto emailContent);
    void sendCustomMessage(String to, String subject, String text);
}
