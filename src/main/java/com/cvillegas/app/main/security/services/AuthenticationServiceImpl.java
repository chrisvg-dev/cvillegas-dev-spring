package com.cvillegas.app.main.security.services;

import com.cvillegas.app.main.security.dto.JwtAuthenticationResponse;
import com.cvillegas.app.main.security.dto.LoginRequestDto;
import com.cvillegas.app.main.security.dto.UserRegistrationDto;
import com.cvillegas.app.main.security.model.CustomUser;
import com.cvillegas.app.main.security.model.User;
import com.cvillegas.app.main.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User signup(UserRegistrationDto request){
        User user = new User();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
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
        return response;

    }

}
