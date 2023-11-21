package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseType extends BaseEntity {
    private String name;
    private String description;
}
