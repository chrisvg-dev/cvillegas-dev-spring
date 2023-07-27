package com.cvillegas.app.main.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RequiredArgsConstructor
@Data @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDetailsDto {
    private String name;
    private String description;
    private String language;
    private String type;
    private String platform;
    private MultipartFile file;
}
