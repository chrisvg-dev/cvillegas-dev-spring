package com.cvillegas.app.MainApp.controller;

import com.cvillegas.app.MainApp.dto.BasicResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cvillegas.app.MainApp.utils.Constants.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/server")
public class ServerController {

    @GetMapping
    public ResponseEntity<?> index() {
        BasicResponseDto basicResponse = BasicResponseDto.builder()
                .code(OK_STATUS).message("Server is working...").build();
        return ResponseEntity.ok(basicResponse);
    }
}
