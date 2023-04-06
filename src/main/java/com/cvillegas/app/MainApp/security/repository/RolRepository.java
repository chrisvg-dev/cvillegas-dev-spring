package com.cvillegas.app.MainApp.security.repository;

import com.cvillegas.app.MainApp.security.entity.Role;
import com.cvillegas.app.MainApp.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRolName(RolName rolName);
}