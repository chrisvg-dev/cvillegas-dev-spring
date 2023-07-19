package com.cvillegas.app.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {
    private String name;
    private String description;
    private String language;
    private String type;
    private String platform;
    @Column(length=10485760)
    private String file;
}
