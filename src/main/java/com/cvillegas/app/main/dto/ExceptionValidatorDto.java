package com.cvillegas.app.main.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public class ExceptionValidatorDto {
    private String key;
    private Map<String,String> errors;
}
