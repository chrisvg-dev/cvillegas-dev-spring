package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
    List<Settings> findByParamContains(String key);
}
