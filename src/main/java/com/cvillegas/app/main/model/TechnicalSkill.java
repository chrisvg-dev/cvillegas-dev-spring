package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technical_skills")
public class TechnicalSkill extends BaseEntity {
    private String name;
    private String description;
    private String image;
}
