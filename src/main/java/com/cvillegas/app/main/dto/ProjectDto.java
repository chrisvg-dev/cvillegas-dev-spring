package com.cvillegas.app.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProjectDto {
    private String description;
    private String title;
    private String username;
    private String component;
    private String icon;
}
