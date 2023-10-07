package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.BaseEmailContentDto;

public interface IEmailService {

    void sendSimpleMessage(BaseEmailContentDto emailContent);
    void sendCustomMessage(String to, String subject, String text);
}
