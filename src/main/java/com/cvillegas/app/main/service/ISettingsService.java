package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.SettingDto;
import com.cvillegas.app.main.model.Setting;

import java.util.List;
import java.util.Map;

public interface ISettingsService {
    Map<String, String> findByKey(String key) throws Exception;
    Map<String, String> findAll(String key) throws Exception;
    List<Setting> findAllSettings();
    BasicResponseDto saveSetting(SettingDto request);
    BasicResponseDto updateSetting(Long id, SettingDto request);
}
