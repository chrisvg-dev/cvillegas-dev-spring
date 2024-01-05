package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.SkillsWrapperDto;
import com.cvillegas.app.main.model.TechnicalSkill;
import com.cvillegas.app.main.service.ITechnicalSkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${api.prefix}")
public class TechnicalSkillController {

    private final ITechnicalSkillService service;

    @GetMapping("/info/skills")
    public ResponseEntity<SkillsWrapperDto> findAll() {
        return ResponseEntity.ok( this.service.findAll() );
    }

}
