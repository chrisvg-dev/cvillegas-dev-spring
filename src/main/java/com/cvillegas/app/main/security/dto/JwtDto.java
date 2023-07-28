package com.cvillegas.app.main.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtDto {
    private HttpStatus status;
    private String token;
    private String username;
    private String message;
    private boolean hasError = false;
    private Collection<? extends GrantedAuthority> authorities;
}
