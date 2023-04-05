package com.cvillegas.app.MainApp.controller;

import com.cvillegas.app.MainApp.dto.BasicResponseDto;
import com.cvillegas.app.MainApp.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cvillegas.app.MainApp.utils.Constants.OK_STATUS;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/projects")
public class UserController {
    private final IProjectService service;

    public UserController(IProjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(this.service.findAllProjects());
    }
}
