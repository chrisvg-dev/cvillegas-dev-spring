package com.cvillegas.app.main.security.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class BaseResponse {
    private String message;
    private HttpStatus status;
}
