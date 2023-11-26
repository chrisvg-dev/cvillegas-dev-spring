package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.model.TechnicalSkill;
import com.cvillegas.app.main.model.repository.ITechnicalSkillRepository;
import com.cvillegas.app.main.service.ITechnicalSkillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TechnicalSkillServiceImpl implements ITechnicalSkillService {
    private final ITechnicalSkillRepository repository;
    @Override
    public List<TechnicalSkill> findAll() {
        return this.repository.findAll();
    }
}
