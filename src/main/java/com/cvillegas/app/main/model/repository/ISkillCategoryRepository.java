package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.dto.TechSkillDto;
import com.cvillegas.app.main.enums.SkillCategory;
import com.cvillegas.app.main.model.TechSkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISkillCategoryRepository extends JpaRepository<TechSkillCategory, Long> {
    Optional<TechSkillCategory> findBySkillCategory(SkillCategory skillCategory);

}
