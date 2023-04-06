package com.cvillegas.app.MainApp.security.service;

import com.cvillegas.app.MainApp.model.User;
import com.cvillegas.app.MainApp.security.entity.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        User usuario = userService.getByNombreUsuario(nombreUsuario).get();
        return PrincipalUser.build(usuario);
    }
}