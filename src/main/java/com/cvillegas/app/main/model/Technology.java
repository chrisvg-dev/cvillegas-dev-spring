package com.cvillegas.app.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "technologies")
@Data @AllArgsConstructor @NoArgsConstructor
public class Technology extends BaseEntity {
    private String name;
    private String description;
}
