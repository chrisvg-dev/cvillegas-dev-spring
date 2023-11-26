package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISettingsRepository extends JpaRepository<Setting, Long> {
    List<Setting> findByParamContains(String key);
}
