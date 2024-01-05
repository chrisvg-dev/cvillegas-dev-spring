package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<Job, Long> {
}
