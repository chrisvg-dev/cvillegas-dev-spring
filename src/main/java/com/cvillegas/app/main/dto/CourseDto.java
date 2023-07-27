package com.cvillegas.app.main.dto;

import com.cvillegas.app.main.model.BaseEntity;
import com.cvillegas.app.main.model.Course;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private String language;
    private String type;
    private String platform;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
        this.language = course.getLanguage();
        this.type = course.getType();
        this.platform = course.getPlatform();
    }
}
