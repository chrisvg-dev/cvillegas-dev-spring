package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.ProjectDto;
import com.cvillegas.app.main.model.Project;
import com.cvillegas.app.main.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/utils")
@Slf4j
public class ProjectsController {
    private final IProjectService projectService;

    public ProjectsController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Project>> index() {
        log.info( "Sending records..." );
        return ResponseEntity.ok( this.projectService.findAllProjects());
    }

    @PostMapping("/add-project")
    public ResponseEntity<?> saveProject(@RequestBody ProjectDto projectDto) {
        Project project = this.projectService.saveProject(projectDto);

        if (Objects.nonNull(project) ) {
            return ResponseEntity.ok(project);
        }

        return ResponseEntity.ok( new BasicResponseDto(HttpStatus.BAD_REQUEST, "Error al registrar...") );
    }
}