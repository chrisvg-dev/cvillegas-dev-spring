package com.cvillegas.app.main.security.controllers;

import com.cvillegas.app.main.dto.Message;
import com.cvillegas.app.main.security.dto.*;
import com.cvillegas.app.main.security.model.User;
import com.cvillegas.app.main.security.services.AuthenticationService;
import com.cvillegas.app.main.security.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Value("${security.jwt.accessTokenCookieName}")
    private String cookieName; // TODO meter a settings

    @Value("${user.data.domain:localhost}")
    private String domain; // TODO meter a settings
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserRegistrationDto request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody LoginRequestDto request) {
        log.info("Login request {} was received.", request);
        Cookie cookie = checkSession(httpServletRequest);
        if (Objects.nonNull(cookie)) {
            JwtErrorResponse errorResponse = new JwtErrorResponse();
            errorResponse.setMessage("There is a session previously associated. Please log out and try again.");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        try {
            JwtAuthenticationResponse response = authenticationService.login(request);
            log.info("Login response {} was created successfully.", response);
            CookieUtil.create(httpServletResponse, cookieName, response.getToken(), false, -1, domain);
            log.info("HttpOnly cookie for JWT authentication was set.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            JwtErrorResponse errorResponse = new JwtErrorResponse();
            errorResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @GetMapping("/logOut")
    public ResponseEntity<Message> logOut(HttpServletRequest request, HttpServletResponse httpServletResponse){
        Cookie cookie = checkSession(request);
        log.info("Logout request {} was received.", request);
        if (Objects.nonNull(cookie)) {
            CookieUtil.clear(httpServletResponse, cookieName, domain);
            log.info("Session {} was closed", cookie.getValue());
            return ResponseEntity.ok().body(new Message("Session was closed successfully"));
        }
        return ResponseEntity.ok().body(new Message("There is no session to be closed."));
    }

    private Cookie checkSession(HttpServletRequest request) {
        return WebUtils.getCookie(request, cookieName);
    }
}
