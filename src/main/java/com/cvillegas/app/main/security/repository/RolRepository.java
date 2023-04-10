package com.cvillegas.app.main.security.repository;

import com.cvillegas.app.main.security.entity.Role;
import com.cvillegas.app.main.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRolName(RolName rolName);
}