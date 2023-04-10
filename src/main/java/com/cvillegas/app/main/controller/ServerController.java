package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cvillegas.app.main.utils.Constants.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/info/server")
public class ServerController {

    @GetMapping
    public ResponseEntity<Object> index() {
        BasicResponseDto basicResponse = BasicResponseDto.builder()
                .code(OK_STATUS).message("Server is working...").build();
        return ResponseEntity.ok(basicResponse);
    }
}
