package com.cvillegas.app.main.dto;

import com.cvillegas.app.main.model.TechnicalSkill;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SkillWrapperItemDto {
    private List<TechSkillDto> skills;
}
