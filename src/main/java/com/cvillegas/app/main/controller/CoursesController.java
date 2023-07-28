package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.service.ICourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/data/my-courses")
public class CoursesController {
    private static final Logger LOG = LoggerFactory.getLogger( CoursesController.class );
    private final ICourseService courseService;

    public CoursesController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> findAll(@RequestParam(value = "criteria", required = false) String criteria) {
        LOG.debug(criteria);
        return ResponseEntity.ok( this.courseService.findAll(criteria.toUpperCase()) );
    }

    @GetMapping("/getCertificate/{id}")
    public ResponseEntity<String> findAll(@PathVariable("id") Long id) {
        return ResponseEntity.ok( this.courseService.findCertificateById(id) );
    }

    @PostMapping(value = "/putCertificate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> saveCourse(@RequestPart("course") CourseDto course, @RequestPart("file") MultipartFile file) throws IOException {
        LOG.info( "{} was received", course );
        if ( Objects.isNull( file ) ) return new ResponseEntity<>("This request has no file to be saved.", HttpStatus.BAD_REQUEST);

        Course courseSaved = this.courseService.saveCourse( course, file );
        BasicResponseDto basicResponseDto;
        if ( Objects.isNull( courseSaved ) )  {
            basicResponseDto = new BasicResponseDto(HttpStatus.BAD_REQUEST, "There was an error. The records could not br saved.");
        } else {
            basicResponseDto = new BasicResponseDto(HttpStatus.OK, "Record saved");
        }
        return ResponseEntity.ok( basicResponseDto );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BasicResponseDto> delete(@PathVariable("id") Long id) {
        BasicResponseDto basicResponseDto = new BasicResponseDto();
        basicResponseDto.setCode(HttpStatus.OK);
        basicResponseDto.setMessage( this.courseService.deleteCourseById(id) );
        return ResponseEntity.ok( basicResponseDto );
    }
}
