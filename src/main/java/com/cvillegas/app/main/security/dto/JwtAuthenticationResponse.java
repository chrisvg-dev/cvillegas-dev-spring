package com.cvillegas.app.main.security.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationResponse extends BaseResponse {
    private String token;
    private String refreshToken;
}
