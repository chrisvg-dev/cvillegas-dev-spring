package com.cvillegas.app.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "platforms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Platform extends BaseEntity {
    private String name;
    private String description;
}