package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.CourseDetailsDto;
import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.dto.CriteriaDto;
import com.cvillegas.app.main.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ICourseService {
    List<CourseDto> findAll(String criteria);
    String findCertificateById(Long id);
    Course saveCourse(CourseDto course, MultipartFile file) throws IOException;

    String deleteCourseById( Long id );
}
