package com.cvillegas.app.MainApp.model.repository;

import com.cvillegas.app.MainApp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
