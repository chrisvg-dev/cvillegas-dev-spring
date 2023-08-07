package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.CourseDetailsDto;
import com.cvillegas.app.main.dto.CourseDto;
import com.cvillegas.app.main.dto.CriteriaDto;
import com.cvillegas.app.main.model.Course;
import com.cvillegas.app.main.model.repository.ICourseRepository;
import com.cvillegas.app.main.service.ICourseService;
import com.cvillegas.app.main.utils.Base64Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
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
        String certificate = Objects.nonNull( this.courseRepository.findCertificateById(id) )
                ? this.courseRepository.findCertificateById(id)
                : null;
        return certificate;
    }

    @Override
    public Course saveCourse(CourseDto courseDetailsDto, MultipartFile file) throws IOException {
        String cleanedBase64 = convertFileToBase64( file );

        // Fill new object to be saved
        Course course = new Course();
        course.setName(courseDetailsDto.getName() );
        course.setDescription(courseDetailsDto.getDescription() );
        course.setType(courseDetailsDto.getType() );
        //course.setLanguage(courseDetailsDto.getLanguage() );
        course.setFile( cleanedBase64 );
        //course.setPlatform( courseDetailsDto.getPlatform() );
        course.setCreatedAt( new Date() );
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
