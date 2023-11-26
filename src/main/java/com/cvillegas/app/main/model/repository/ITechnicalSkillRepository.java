package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.TechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITechnicalSkillRepository extends JpaRepository<TechnicalSkill, Long> {
}
