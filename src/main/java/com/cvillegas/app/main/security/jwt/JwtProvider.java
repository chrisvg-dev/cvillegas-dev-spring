package com.cvillegas.app.main.security.jwt;

import com.cvillegas.app.main.security.entity.PrincipalUser;
import com.cvillegas.app.main.service.ISettingsService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final ISettingsService settingsService;

    public JwtProvider(ISettingsService settingsService) {
        this.settingsService = settingsService;
    }

    public String generateToken(Authentication authentication) throws Exception {
        PrincipalUser mainUser = (PrincipalUser) authentication.getPrincipal();

        Map<String, String> settingsMap = this.settingsService.findByKey("JWT");
        long expiration = Long.parseLong(settingsMap.get("JWT_EXPIRATION"));
        String secretKey = settingsMap.get("JWT_SECRET_KEY");

        Map<String, String> claims = new HashMap<>();
        claims.put("username", mainUser.getUsername());
        claims.put("name", mainUser.getName());

        return Jwts.builder()
                .setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token) throws Exception {
        Map<String, String> settingsMap = this.settingsService.findByKey("JWT");
        String secretKey = settingsMap.get("JWT_SECRET_KEY");
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) throws Exception {
        try {
            Map<String, String> settingsMap = this.settingsService.findByKey("JWT");
            String secretKey = settingsMap.get("JWT_SECRET_KEY");

            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e){
            logger.error("token mal formado");
        } catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        } catch (ExpiredJwtException e){
            logger.error("token expirado");
        } catch (IllegalArgumentException e){
            logger.error("token vacío");
        } catch (SignatureException e){
            logger.error("fail en la firma");
        }
        return false;
    }
}