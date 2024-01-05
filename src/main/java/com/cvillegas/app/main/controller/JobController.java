package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.JobRegistrationDto;
import com.cvillegas.app.main.dto.ResponseWrapperDto;
import com.cvillegas.app.main.model.Job;
import com.cvillegas.app.main.service.IJobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
@Slf4j
@RequiredArgsConstructor
public class JobController {
    private final IJobService jobService;

    @GetMapping("/info/jobs")
    public ResponseWrapperDto findALllJobs() {
        return jobService.findAllJobs();
    }

    @PostMapping("/info/addJob")
    public ResponseEntity<Job> save(@Valid @RequestBody JobRegistrationDto request) {
        return ResponseEntity.ok(jobService.addNewJob(request));
    }

    @DeleteMapping("/info/deleteJob/{id}")
    public ResponseEntity<BasicResponseDto> delete(@PathVariable Long id) {
        BasicResponseDto response = new BasicResponseDto();
        if (jobService.deleteJob(id)) {
            response.setCode(HttpStatus.OK);
            response.setMessage("Job deleted successfully");
            return ResponseEntity.ok(response);
        }
        response.setCode(HttpStatus.NOT_FOUND);
        response.setMessage("Job not found");
        return ResponseEntity.ok(response);
    }
}
