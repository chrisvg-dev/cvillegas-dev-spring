package com.cvillegas.app.MainApp.controller;

import com.cvillegas.app.MainApp.service.IProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/data/projects")
public class ProjectsController {
    private final IProjectService service;

    public ProjectsController(IProjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(this.service.findAllProjects());
    }
}
