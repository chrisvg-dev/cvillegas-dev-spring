package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cvillegas.app.main.utils.Constants.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ServerController {

    @GetMapping("/info/server")
    public ResponseEntity<Object> index() {
        BasicResponseDto basicResponse = BasicResponseDto.builder()
                .code(HttpStatus.OK).message("Server is working...").build();
        return ResponseEntity.ok(basicResponse);
    }
}