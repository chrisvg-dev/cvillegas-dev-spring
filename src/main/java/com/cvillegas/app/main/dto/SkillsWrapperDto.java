package com.cvillegas.app.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Setter @SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkillsWrapperDto {
    private String status;
    private List<TechSkillDto> data;

    public List<TechSkillDto> getData() {
        if (data == null) {
            return new ArrayList<>();
        }
        return data;
    }
}
