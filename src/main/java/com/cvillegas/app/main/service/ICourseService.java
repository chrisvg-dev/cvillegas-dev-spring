package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.dto.CriteriaDto;
import com.cvillegas.app.main.model.Course;

import java.util.List;

public interface ICourseService {
    List<CourseDto> findAll(String criteria);
    String findCertificateById(Long id);
}
