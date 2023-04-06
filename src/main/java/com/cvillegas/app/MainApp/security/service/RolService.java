package com.cvillegas.app.MainApp.security.service;

import com.cvillegas.app.MainApp.security.entity.Rol;
import com.cvillegas.app.MainApp.security.enums.RolName;
import com.cvillegas.app.MainApp.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Rol> getByRolNombre(RolName rolNombre){
        return rolRepository.findByRolName(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}