package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/data/projects")
@Slf4j
public class ProjectsController {
    private final IProjectService service;

    public ProjectsController(IProjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        log.info( "Sending records..." );
        return ResponseEntity.ok( this.service.findAllProjects());
    }
}
