package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoursePlatformRepository extends JpaRepository<Platform, Long> {
    Optional<Platform> findByName(String name);
}
