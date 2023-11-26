package com.cvillegas.app.main.model;

import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "settings", indexes = @Index(columnList = "param, content"))
@SuperBuilder
public class Setting extends BaseEntity {
    private String param;
    private String content;
    private String description;
}
