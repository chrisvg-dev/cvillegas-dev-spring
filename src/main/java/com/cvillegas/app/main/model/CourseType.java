package com.cvillegas.app.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseType extends BaseEntity {
    private String name;
    private String description;
}
