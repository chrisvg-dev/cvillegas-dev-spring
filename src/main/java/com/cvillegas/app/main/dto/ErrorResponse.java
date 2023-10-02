package com.cvillegas.app.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String details;
}
