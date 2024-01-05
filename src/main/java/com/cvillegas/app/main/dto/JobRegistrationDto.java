package com.cvillegas.app.main.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class JobRegistrationDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String company;
    private boolean current;
}
