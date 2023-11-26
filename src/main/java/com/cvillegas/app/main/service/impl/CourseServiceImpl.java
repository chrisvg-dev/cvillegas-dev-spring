package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.dto.CourseRequestDto;
import com.cvillegas.app.main.dto.CoursesWrapper;
import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.model.CourseType;
import com.cvillegas.app.main.model.Platform;
import com.cvillegas.app.main.model.Technology;
import com.cvillegas.app.main.model.repository.ICoursePlatformRepository;
import com.cvillegas.app.main.model.repository.ICourseRepository;
import com.cvillegas.app.main.model.repository.ICourseTechnologyRepository;
import com.cvillegas.app.main.model.repository.ICourseTypeRepository;
import com.cvillegas.app.main.service.ICourseService;
import com.cvillegas.app.main.utils.Base64Converter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;
    private final ICourseTypeRepository courseTypeRepository;
    private final ICourseTechnologyRepository courseTechnologyRepository;
    private final ICoursePlatformRepository coursePlatformRepository;

    @Override
    public CoursesWrapper findAll(String criteria) {
        if (!criteria.isEmpty()) {
            return CoursesWrapper.builder()
                    .courses( this.courseRepository.findByLanguage(criteria) )
                    .platforms( this.coursePlatformRepository.findAll() )
                    .technologies( this.courseTechnologyRepository.findAll() )
                    .types( this.courseTypeRepository.findAll() )
                    .build();
        }
        return buildResponse();
    }

    @Override
    public CoursesWrapper findAll() {
        return buildResponse();
    }

    private CoursesWrapper buildResponse() {
        return CoursesWrapper.builder()
                .courses( this.courseRepository.findBy() )
                .platforms( this.coursePlatformRepository.findAll() )
                .technologies( this.courseTechnologyRepository.findAll() )
                .types( this.courseTypeRepository.findAll() )
                .build();
    }

    @Override
    public String findCertificateById(Long id) {
        return Objects.nonNull( this.courseRepository.findCertificateById(id) )
                ? this.courseRepository.findCertificateById(id)
                : null;
    }

    @Override
    public Course saveCourse(CourseRequestDto courseDetailsDto, MultipartFile file) throws IOException {
        String cleanedBase64 = convertFileToBase64( file );
        CourseType courseType = this.courseTypeRepository.findById(courseDetailsDto.getType()).orElseThrow(() -> new RuntimeException("Course type not found"));
        Technology technology = this.courseTechnologyRepository.findById(courseDetailsDto.getLanguage()).orElseThrow(() -> new RuntimeException("Technology not found"));
        Platform platform = this.coursePlatformRepository.findById(courseDetailsDto.getPlatform()).orElseThrow(() -> new RuntimeException("Platform not found"));

        // Fill new object to be saved
        Course course = new Course();
        course.setName(courseDetailsDto.getName() );
        course.setDescription(courseDetailsDto.getDescription() );
        course.setCourseType(courseType);
        course.setTechnology(technology);
        course.setFile( cleanedBase64 );
        course.setPlatform( platform );
        course.setCreatedAt( LocalDateTime.now() );
        course.setUpdatedAt( LocalDateTime.now() );
        return courseRepository.save(course);
    }

    @Override
    public String deleteCourseById(Long id) {
        Course course = this.courseRepository.findById(id).orElse(null);
        log.info( "You are about to delete this course id={}", id );
        if (Objects.isNull(course)) return "The course you are looking for does not exist";
        this.courseRepository.deleteById( course.getId() );
        log.info( "Record with this id {} was deleted", course.getId() );
        return "The course has been deleted.";
    }

    private String convertFileToBase64( MultipartFile certificate ) throws IOException {
        String fileFormat = "data:image;base64,%s";
        String certificateBase64 = Base64Converter.convertToString(certificate);
        String cleanedBase64 = String.format( fileFormat, certificateBase64 );
        return cleanedBase64;
    }
}
