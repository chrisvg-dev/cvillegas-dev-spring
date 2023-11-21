package com.cvillegas.app.main.dto;

import com.cvillegas.app.main.model.BaseEntity;
import com.cvillegas.app.main.model.Course;
import lombok.*;

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
        this.language = course.getTechnology().getName();
        this.type = course.getCourseType().getName();
        this.platform = course.getPlatform().getName();
    }
}
