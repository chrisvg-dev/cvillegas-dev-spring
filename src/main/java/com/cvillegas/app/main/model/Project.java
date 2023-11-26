package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class Project extends BaseEntity{
    private String description;
    private String title;
    private String username;
    private String component;
    private String icon;
}
