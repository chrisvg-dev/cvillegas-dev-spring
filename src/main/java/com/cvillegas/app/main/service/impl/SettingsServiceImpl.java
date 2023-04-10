package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.model.Settings;
import com.cvillegas.app.main.model.repository.SettingsRepository;
import com.cvillegas.app.main.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SettingsServiceImpl implements ISettingsService {
    private final SettingsRepository repository;

    public SettingsServiceImpl(SettingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, String> findByKey(String key) throws Exception {
        List<Settings> settings = this.repository.findByParamContains(key);
        if (settings.isEmpty()) {
            throw new Exception("There is no information in the database");
        }

        Map<String, String> settingsMap = settings.stream().collect(
                Collectors.toMap(Settings::getParam, Settings::getContent)
        );

        return settingsMap;
    }

    @Override
    public List<Settings> findAllSettings() {
        return this.repository.findAll();
    }

}
