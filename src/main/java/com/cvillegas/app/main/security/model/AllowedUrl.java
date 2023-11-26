package com.cvillegas.app.main.security.model;

import com.cvillegas.app.main.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class AllowedUrl extends BaseEntity {
    private String urlPattern;
    private String description;
}
