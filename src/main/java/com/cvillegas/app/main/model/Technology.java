package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "technologies")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Technology extends BaseEntity {
    private String name;
    private String description;
}
