package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.SettingDto;
import com.cvillegas.app.main.model.Setting;
import com.cvillegas.app.main.model.repository.ISettingsRepository;
import com.cvillegas.app.main.service.ISettingsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class SettingsServiceImpl implements ISettingsService {
    private final ISettingsRepository repository;

    public SettingsServiceImpl(ISettingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, String> findByKey(String key) throws Exception {
        List<Setting> settings = this.repository.findByParamContains(key);
        return buildMap(settings);
    }

    @Override
    public Map<String, String> findAll(String key) throws Exception {
        return buildMap(findAllSettings());
    }

    @Override
    public List<Setting> findAllSettings() {
        return this.repository.findAll();
    }

    @Override
    public BasicResponseDto saveSetting(SettingDto request) {
        Setting settings = new Setting();
        settings.setParam(request.getParam());
        settings.setDescription(request.getDescription());
        settings.setContent(request.getContent());
        Setting saved = this.repository.save(settings);

        if (Objects.nonNull(saved.getId())) {
            return BasicResponseDto.builder().code(HttpStatus.OK).message("Setting record was saved.").build();
        }
        return BasicResponseDto.builder().code(HttpStatus.INTERNAL_SERVER_ERROR).message("Setting record was not saved.").build();
    }

    @Override
    public BasicResponseDto updateSetting(Long id, SettingDto request) {
        Setting setting = this.repository.findById(id).orElse(null);

        if (Objects.nonNull(setting)) {
            setting.setParam(request.getParam());
            setting.setDescription(request.getDescription());
            setting.setContent(request.getContent());
        }

        Setting updated = this.repository.save(setting);

        if (Objects.nonNull(updated)) {
            return BasicResponseDto.builder().code(HttpStatus.OK).message("Setting record was updated.").build();
        }
        return BasicResponseDto.builder().code(HttpStatus.INTERNAL_SERVER_ERROR).message("Setting record was not updated.").build();
    }

    private Map<String, String> buildMap(List<Setting> settings) throws IllegalArgumentException {
        if (settings.isEmpty()) {
            throw new IllegalArgumentException("There is no information in the database");
        }
        return settings.stream().collect(Collectors.toMap(Setting::getParam, Setting::getContent));
    }
}
