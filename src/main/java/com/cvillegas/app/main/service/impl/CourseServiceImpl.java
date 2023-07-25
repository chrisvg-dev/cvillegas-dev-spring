package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.dto.CriteriaDto;
import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.model.repository.ICourseRepository;
import com.cvillegas.app.main.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;

    public CourseServiceImpl(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<CourseDto> findAll(String criteria) {
        if (criteria.length() > 0) {
            return this.courseRepository.findByLanguage(criteria);
        }
        return this.courseRepository.findBy();
    }

    @Override
    public String findCertificateById(Long id) {
        return this.courseRepository.findCertificateById(id);
    }
}
