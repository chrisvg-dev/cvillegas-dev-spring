package com.cvillegas.app.main.service;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.JobRegistrationDto;
import com.cvillegas.app.main.dto.ResponseWrapperDto;
import com.cvillegas.app.main.model.Job;

import java.util.List;

public interface IJobService {
    ResponseWrapperDto findAllJobs();
    Job addNewJob(JobRegistrationDto request);
    Job updateJob(JobRegistrationDto request);
    boolean deleteJob(Long id);
}
