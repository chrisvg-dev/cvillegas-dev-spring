package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.model.repository.ICourseRepository;
import com.cvillegas.app.main.service.ICourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;

    public CourseServiceImpl(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }
}
