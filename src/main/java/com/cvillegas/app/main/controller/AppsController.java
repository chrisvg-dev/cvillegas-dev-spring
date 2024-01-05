package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.Base64ResponseDto;
import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.FileResponseDto;
import com.cvillegas.app.main.utils.Base64Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.cvillegas.app.main.utils.Base64Converter.convertToString;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class AppsController {

    @PostMapping(value = "/apps/base64Converter", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<FileResponseDto> convertToBase64(@RequestPart("file[]") MultipartFile[] files)
            throws IOException {

        List<Base64ResponseDto> responseList = Arrays.stream(files).map(item -> {
            Base64ResponseDto base64ResponseDto = new Base64ResponseDto();
            try {
                String base64 = convertToString(item);
                String fileExtension = item.getOriginalFilename()
                        .substring(item.getOriginalFilename().lastIndexOf(".") + 1);

                base64ResponseDto.setFilename(item.getOriginalFilename());
                base64ResponseDto.setFileExtension(fileExtension);
                base64ResponseDto.setFileSize(String.valueOf(item.getSize()));
                base64ResponseDto.setBase64(base64);
                log.info(base64);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return base64ResponseDto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(new FileResponseDto(HttpStatus.OK, responseList));
    }

}
