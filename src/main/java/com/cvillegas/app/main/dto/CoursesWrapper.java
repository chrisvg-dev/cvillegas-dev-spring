package com.cvillegas.app.main.dto;

import com.cvillegas.app.main.model.CourseType;
import com.cvillegas.app.main.model.Platform;
import com.cvillegas.app.main.model.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CoursesWrapper {
    private List<CourseDto> courses;
    private List<Technology> technologies;
    private List<CourseType> types;
    private List<Platform> platforms;
}
