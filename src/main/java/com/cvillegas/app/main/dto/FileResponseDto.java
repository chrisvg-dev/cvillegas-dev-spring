package com.cvillegas.app.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class FileResponseDto {
    private HttpStatus status;
    private List<Base64ResponseDto> base64;
}
