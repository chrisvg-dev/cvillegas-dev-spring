package com.cvillegas.app.main.security.repository;

import com.cvillegas.app.main.security.enums.ERole;
import com.cvillegas.app.main.security.model.Role;
import com.cvillegas.app.main.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
    Optional<User> findByRoles(Role role);

    Boolean existsByEmail(String email);

}
