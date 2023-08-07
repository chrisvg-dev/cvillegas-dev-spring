package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.utils.dto.CourseCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT new com.cvillegas.app.main.dto.CourseDto(c) FROM Course c ORDER BY c.id DESC")
    List<CourseDto> findBy();

    @Query("SELECT new com.cvillegas.app.main.dto.CourseDto(c) FROM Course c")
    List<CourseDto> findByLanguage(String language);
    @Query("SELECT c.file FROM Course c WHERE c.id = :id")
    String findCertificateById(Long id);

}
