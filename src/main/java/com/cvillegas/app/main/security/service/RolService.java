package com.cvillegas.app.main.security.service;

import com.cvillegas.app.main.security.entity.Role;
import com.cvillegas.app.main.security.enums.RolName;
import com.cvillegas.app.main.security.repository.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Optional<Role> getByRolNombre(RolName rolNombre){
        return rolRepository.findByRolName(rolNombre);
    }

    public void save(Role rol){
        rolRepository.save(rol);
    }
}