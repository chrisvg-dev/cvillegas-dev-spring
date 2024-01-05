package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.SkillWrapperItemDto;
import com.cvillegas.app.main.dto.SkillsWrapperDto;
import com.cvillegas.app.main.dto.TechSkillDto;
import com.cvillegas.app.main.enums.SkillCategory;
import com.cvillegas.app.main.enums.StyleClassEnum;
import com.cvillegas.app.main.model.TechSkillCategory;
import com.cvillegas.app.main.model.TechnicalSkill;
import com.cvillegas.app.main.model.repository.ITechnicalSkillRepository;
import com.cvillegas.app.main.service.ITechnicalSkillService;
import com.cvillegas.app.main.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TechnicalSkillServiceImpl implements ITechnicalSkillService {
    private final ITechnicalSkillRepository repository;
    private static final SecureRandom random = new SecureRandom();

    @Override
    public SkillsWrapperDto findAll() {
        List<TechSkillDto> skills = this.repository.findAllRecords();
        SkillsWrapperDto wrapper = new SkillsWrapperDto();
        wrapper.setData(new ArrayList<>());
        wrapper.setStatus(Constants.OK_RESPONSE);
        wrapper.getData().addAll(skills);
        return wrapper;
    }

    // TODO pending
    @Override
    public void save(TechSkillDto skill) {
        TechnicalSkill technicalSkill = TechnicalSkill.builder()
                .name(skill.getName())
                .category( null )
                .styleClass(randomEnumValue(StyleClassEnum.class).getStyleClass())
                .level(skill.getLevel())
                .build();
        this.repository.save(technicalSkill);
    }

    public static <T extends Enum<?>> T randomEnumValue(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
