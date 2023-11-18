package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.*;
import com.cvillegas.app.main.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ICourseService {
    CoursesWrapper findAll(String criteria);
    CoursesWrapper findAll();
    String findCertificateById(Long id);
    Course saveCourse(CourseRequestDto course, MultipartFile file) throws IOException;

    String deleteCourseById( Long id );
}
