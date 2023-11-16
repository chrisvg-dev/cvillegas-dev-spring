package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICourseTypeRepository extends JpaRepository<CourseType, Long> {
    Optional<CourseType> findByName(String name);
}
