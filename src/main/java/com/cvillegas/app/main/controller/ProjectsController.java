package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.Message;
import com.cvillegas.app.main.dto.ProjectDto;
import com.cvillegas.app.main.model.Project;
import com.cvillegas.app.main.service.IProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProjectsController {
    private final IProjectService projectService;

    @GetMapping("/info/projects")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Project>> index() {
        log.info("Sending records...");
        return ResponseEntity.ok(this.projectService.findAllProjects());
    }

    @PostMapping("/add-project")
    public ResponseEntity<?> saveProject(@RequestBody ProjectDto projectDto) {
        Project project = this.projectService.saveProject(projectDto);
        log.info(project + "created");
        if (Objects.nonNull(project)) {
            return ResponseEntity.ok(project);
        }

        return ResponseEntity.ok(new BasicResponseDto(HttpStatus.BAD_REQUEST, "Error al registrar..."));
    }

    @DeleteMapping("/delete-project/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(new Message("Id must not be null"));
        }

        log.info("Deleting record with this id {}", id);
        try {
            this.projectService.deleteProject(id);
            return ResponseEntity.ok(new Message("Record with id " + id + " was deleted."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Message("There was a problem during deletion."));
        }

    }
}