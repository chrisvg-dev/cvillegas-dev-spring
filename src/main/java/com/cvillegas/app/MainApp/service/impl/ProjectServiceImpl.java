package com.cvillegas.app.MainApp.service.impl;

import com.cvillegas.app.MainApp.model.Project;
import com.cvillegas.app.MainApp.model.repository.ProjectRepository;
import com.cvillegas.app.MainApp.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
