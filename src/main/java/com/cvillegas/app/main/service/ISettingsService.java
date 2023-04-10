package com.cvillegas.app.main.service;

import com.cvillegas.app.main.model.Settings;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ISettingsService {
    Map<String, String> findByKey(String key) throws Exception;
    List<Settings> findAllSettings();
}
