package com.cvillegas.app.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Job extends BaseEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String company;
    @Column(length = 2654654)
    @NotBlank
    private String description;
    private boolean isCurrent;
}
