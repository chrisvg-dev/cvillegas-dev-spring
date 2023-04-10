package com.cvillegas.app.main.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtDto {
    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
}
