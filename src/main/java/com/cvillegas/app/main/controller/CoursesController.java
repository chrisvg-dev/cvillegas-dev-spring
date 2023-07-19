package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.service.ICourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/data/my-courses")
public class CoursesController {
    private final ICourseService courseService;

    public CoursesController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok( this.courseService.findAll() );
    }
}
