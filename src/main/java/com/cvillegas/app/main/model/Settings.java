package com.cvillegas.app.main.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder @Entity
@Table(name = "app_settings")
public class Settings extends BaseEntity {
    private String param;
    private String content;
    private String description;
}
