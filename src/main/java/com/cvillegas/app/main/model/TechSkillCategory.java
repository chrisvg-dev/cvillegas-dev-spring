package com.cvillegas.app.main.model;

import com.cvillegas.app.main.enums.SkillCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skill_category")
@SuperBuilder
public class TechSkillCategory extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private SkillCategory skillCategory;
}
