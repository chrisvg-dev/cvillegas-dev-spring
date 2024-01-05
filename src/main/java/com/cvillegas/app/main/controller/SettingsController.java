package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.SettingDto;
import com.cvillegas.app.main.model.Setting;
import com.cvillegas.app.main.service.ISettingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/")
@Slf4j
@RequiredArgsConstructor
public class SettingsController {
    private final ISettingsService settingsService;

    @GetMapping("/info/settings")
    public ResponseEntity<List<Setting>> findAllSettings() {
        return ResponseEntity.ok(settingsService.findAllSettings());
    }

    @PostMapping("/settings/save")
    public ResponseEntity<BasicResponseDto> save(@RequestBody SettingDto request) {
        return ResponseEntity.ok(settingsService.saveSetting(request));
    }
}
