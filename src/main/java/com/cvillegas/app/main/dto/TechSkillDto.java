package com.cvillegas.app.main.dto;

import com.cvillegas.app.main.enums.Level;
import com.cvillegas.app.main.model.TechnicalSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TechSkillDto {
    private String name;
    private String styleClass;
    private String icon;
    private Level level;
    private String description;
    private String category;

    public TechSkillDto(TechnicalSkill technicalSkill) {
        this.name = technicalSkill.getName();
        this.styleClass = technicalSkill.getStyleClass();
        this.icon = technicalSkill.getIcon();
        this.level = technicalSkill.getLevel();
        this.description = technicalSkill.getDescription();
        this.category = technicalSkill.getCategory().getSkillCategory().name();
    }
}