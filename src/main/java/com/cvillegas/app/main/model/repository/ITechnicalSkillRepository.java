package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.dto.TechSkillDto;
import com.cvillegas.app.main.model.TechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITechnicalSkillRepository extends JpaRepository<TechnicalSkill, Long> {
    @Query("SELECT new com.cvillegas.app.main.dto.TechSkillDto(t) FROM TechnicalSkill t")
    List<TechSkillDto> findAllRecords();
}
