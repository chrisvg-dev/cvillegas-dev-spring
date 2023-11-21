package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "platforms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Platform extends BaseEntity {
    private String name;
    private String description;
}