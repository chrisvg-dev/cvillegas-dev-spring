package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
}
