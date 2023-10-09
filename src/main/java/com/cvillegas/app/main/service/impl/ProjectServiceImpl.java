package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.ProjectDto;
import com.cvillegas.app.main.model.Project;
import com.cvillegas.app.main.model.repository.ProjectRepository;
import com.cvillegas.app.main.service.IProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {
    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> findAllProjects() {
        return this.repository.findAll();
    }

    @Override
    public Project saveProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setTitle(project.getTitle());
        project.setDescription(project.getDescription());
        project.setIcon("");
        project.setComponent( projectDto.getComponent() );
        Date now = new Date();
        project.setCreatedAt( now );
        project.setUpdatedAt(LocalDateTime.now());
        return repository.save(project);
    }
}
