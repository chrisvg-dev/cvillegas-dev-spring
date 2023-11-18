package com.cvillegas.app.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDto {
    private Long id;
    private String name;
    private String description;
    private Long language;
    private Long type;
    private Long platform;
}
