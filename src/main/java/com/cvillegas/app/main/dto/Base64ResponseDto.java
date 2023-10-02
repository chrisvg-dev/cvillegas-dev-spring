package com.cvillegas.app.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base64ResponseDto {
    private String filename;
    private String fileExtension;
    private String fileSize;
    private String base64;
}
