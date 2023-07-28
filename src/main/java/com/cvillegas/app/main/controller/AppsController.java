package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.utils.Base64Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/apps")
@CrossOrigin(origins = "*")
public class AppsController {

    @PostMapping(value = "/base64Converter", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BasicResponseDto> convertToBase64(@RequestPart("file") MultipartFile file) throws IOException {
        String base64 = Base64Converter.convertToString(file);

        return ResponseEntity.ok( new BasicResponseDto(HttpStatus.OK, base64) );
    }

}
