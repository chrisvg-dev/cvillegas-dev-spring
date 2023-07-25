package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.dto.CriteriaDto;
import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/data/my-courses")
@Slf4j
public class CoursesController {
    private final ICourseService courseService;

    public CoursesController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> findAll(@RequestParam(value = "criteria", required = false) String criteria) {
        log.info(criteria);
        return ResponseEntity.ok( this.courseService.findAll(criteria.toUpperCase()) );
    }

    @GetMapping("/getCertificate/{id}")
    public ResponseEntity<String> findAll(@PathVariable("id") Long id) {
        return ResponseEntity.ok( this.courseService.findCertificateById(id) );
    }
}
