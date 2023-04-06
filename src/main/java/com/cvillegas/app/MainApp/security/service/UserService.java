package com.cvillegas.app.MainApp.security.service;

import com.cvillegas.app.MainApp.model.User;
import com.cvillegas.app.MainApp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByNombreUsuario(String username){
        return userRepository.findByUsername(username);
    }

    public boolean existsByNombreUsuario(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }
}