package com.cvillegas.app.main.security.services;

import com.cvillegas.app.main.security.dto.JwtAuthenticationResponse;
import com.cvillegas.app.main.security.dto.LoginRequestDto;
import com.cvillegas.app.main.security.dto.RefreshTokenRequest;
import com.cvillegas.app.main.security.dto.UserRegistrationDto;
import com.cvillegas.app.main.security.model.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationService {
    User signup(UserRegistrationDto request);
    JwtAuthenticationResponse login(LoginRequestDto request);
    JwtAuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest request);
}
