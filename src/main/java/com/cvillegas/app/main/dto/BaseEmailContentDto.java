package com.cvillegas.app.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEmailContentDto {
    private String from;
    private String to;
    private String text;
    private String subject;
}
