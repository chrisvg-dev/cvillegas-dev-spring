package com.cvillegas.app.main.security.services;

import com.cvillegas.app.main.exceptions.RoleNotFoundException;
import com.cvillegas.app.main.security.dto.JwtAuthenticationResponse;
import com.cvillegas.app.main.security.dto.LoginRequestDto;
import com.cvillegas.app.main.security.dto.RefreshTokenRequest;
import com.cvillegas.app.main.security.dto.UserRegistrationDto;
import com.cvillegas.app.main.security.enums.ERole;
import com.cvillegas.app.main.security.model.CustomUser;
import com.cvillegas.app.main.security.model.Role;
import com.cvillegas.app.main.security.model.User;
import com.cvillegas.app.main.security.repository.RoleRepository;
import com.cvillegas.app.main.security.repository.UserRepository;
import com.cvillegas.app.main.security.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User signup(UserRegistrationDto request){
        Role role = roleRepository.findByRoleName(ERole.ROLE_USER).orElseThrow(() ->
                new RoleNotFoundException("Role name not found"));
        User user = new User();
        user.setName(request.getName().toUpperCase());
        user.setLastName(request.getLastName().toUpperCase());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(role);
        User saved = userRepository.save(user);
        log.info("User was saved successfully.");
        return saved;
    }

    public JwtAuthenticationResponse login(LoginRequestDto request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("INvalid credentials"));
        var jwt = jwtService.generateToken(CustomUser.build(user));
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), CustomUser.build(user));

        JwtAuthenticationResponse response = new JwtAuthenticationResponse(jwt, refreshToken);
        response.setMessage("Authentication successful");
        response.setStatus(HttpStatus.OK);
        log.info("HttpOnly cookie for JWT authentication was set.");
        return response;

    }

    public JwtAuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest request) {
        String email = jwtService.extractUsername(request.getToken());
        User user = userRepository.findByEmail(email).orElseThrow();
        CustomUser customUser = CustomUser.build(user);
        if ( jwtService.isTokenValid(request.getToken(), customUser) ) {
            var jwt = jwtService.generateToken(customUser);
            JwtAuthenticationResponse response = new JwtAuthenticationResponse(jwt, request.getToken());
            response.setMessage("Authentication successful");
            response.setStatus(HttpStatus.OK);
            return response;
        }
        return null;
    }

}
