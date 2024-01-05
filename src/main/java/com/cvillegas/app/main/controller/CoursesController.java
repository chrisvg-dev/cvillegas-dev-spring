package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.dto.CourseRequestDto;
import com.cvillegas.app.main.dto.CoursesWrapper;
import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.service.ICourseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("${api.prefix}")
public class CoursesController {
    private static final Logger LOG = LoggerFactory.getLogger( CoursesController.class );
    private final ICourseService courseService;

    public CoursesController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping({"/info/courses", "info/criteria/{criteria}"})
    public ResponseEntity<CoursesWrapper> findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Map<String, String> pathVariables) {
        if (pathVariables.containsKey("criteria")) {
            return ResponseEntity.ok( this.courseService.findAll(pathVariables.get("criteria").toUpperCase()) );

        }
        return ResponseEntity.ok( this.courseService.findAll() );
    }

    @GetMapping("/info/getCertificate/{id}")
    public ResponseEntity<String> findAll(@PathVariable("id") Long id) {
        return ResponseEntity.ok( this.courseService.findCertificateById(id) );
    }

    @PostMapping(value = "/putCertificate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> saveCourse(@RequestPart("course") CourseRequestDto course, @RequestPart("file") MultipartFile file) throws IOException {
        LOG.info( "{} was received", course );
        if ( Objects.isNull( file ) )
            return new ResponseEntity<>("This request has no file to be saved.", HttpStatus.BAD_REQUEST);

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
