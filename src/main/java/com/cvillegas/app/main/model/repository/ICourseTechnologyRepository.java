package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICourseTechnologyRepository extends JpaRepository<Technology, Long> {
    Optional<Technology> findByName(String name);
}
