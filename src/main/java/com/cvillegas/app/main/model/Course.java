package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "technology")
    private Technology technology;

    @ManyToOne
    @JoinColumn(name = "courseType")
    private CourseType courseType;

    @ManyToOne
    @JoinColumn(name = "platform")
    private Platform platform;

    @Column(length=10485760)
    private String file;
}
