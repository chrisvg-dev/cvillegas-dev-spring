package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.dto.BasicResponseDto;
import com.cvillegas.app.main.dto.JobRegistrationDto;
import com.cvillegas.app.main.dto.ResponseWrapperDto;
import com.cvillegas.app.main.model.Job;
import com.cvillegas.app.main.model.repository.IJobRepository;
import com.cvillegas.app.main.service.IJobService;
import com.cvillegas.app.main.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class JobServiceImpl implements IJobService {
    private final IJobRepository jobRepository;
    @Override
    public ResponseWrapperDto findAllJobs() {
        List<Job> jobs = this.jobRepository.findAll();
        ResponseWrapperDto response = new ResponseWrapperDto();

        if ( jobs.isEmpty() ) {
            response.setKey("NO_DATA");
        } else {
            response.setKey(Constants.OK_RESPONSE);
        }
        response.setData(jobs);
        return response;
    }

    @Override
    public Job addNewJob(JobRegistrationDto request) {
        Job job = Job.builder()
                .name(request.getName())
                .description(request.getDescription())
                .company(request.getCompany())
                .isCurrent(request.isCurrent()).build();
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(JobRegistrationDto request) {
        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        Job job = this.jobRepository.findById(id).orElse(null);

        if (null != job) {
            this.jobRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
