package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
@SuperBuilder
public class Project extends BaseEntity{
    private String description;
    private String title;
    private String type;
    private String url;
    private String observations;
}