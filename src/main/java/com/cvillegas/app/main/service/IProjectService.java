package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.ProjectDto;
import com.cvillegas.app.main.model.Project;

import java.util.List;

public interface IProjectService {
    List<Project> findAllProjects();
    Project saveProject( ProjectDto projectDto );
}
