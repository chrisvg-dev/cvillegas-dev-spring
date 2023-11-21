package com.cvillegas.app.main.security.services;

import com.cvillegas.app.main.security.dto.JwtAuthenticationResponse;
import com.cvillegas.app.main.security.dto.LoginRequestDto;
import com.cvillegas.app.main.security.dto.UserRegistrationDto;
import com.cvillegas.app.main.security.model.User;

public interface AuthenticationService {
    User signup(UserRegistrationDto request);
    JwtAuthenticationResponse login(LoginRequestDto request);

}
