package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.SkillsWrapperDto;
import com.cvillegas.app.main.dto.TechSkillDto;
import com.cvillegas.app.main.model.TechnicalSkill;

import java.util.List;

public interface ITechnicalSkillService {
    SkillsWrapperDto findAll();
    void save(TechSkillDto skill);
}
