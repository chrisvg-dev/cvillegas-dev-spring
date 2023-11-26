package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.ProjectDto;
import com.cvillegas.app.main.model.Project;
import com.cvillegas.app.main.model.repository.IProjectRepository;
import com.cvillegas.app.main.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class ProjectServiceImpl implements IProjectService {
    private final IProjectRepository repository;

    public ProjectServiceImpl(IProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> findAllProjects() {
        return this.repository.findAll();
    }

    @Override
    public Project saveProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setIcon("");
        project.setComponent( projectDto.getComponent() );
        project.setCreatedAt( LocalDateTime.now() );
        project.setUpdatedAt(LocalDateTime.now());
        return repository.save(project);
    }

    @Override
    public void deleteProject(long id) throws Exception {
        Project project = this.repository.findById(id).orElse(null);

        if (Objects.isNull(project)) {
            throw new Exception( "There is no records with this id: " + id );
        }

        this.repository.deleteById(project.getId() );
        log.info( project + " was deleted" );
    }
}
