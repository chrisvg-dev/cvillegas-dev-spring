package com.cvillegas.app.main.security.controller;

import com.cvillegas.app.main.dto.Message;
import com.cvillegas.app.main.model.User;
import com.cvillegas.app.main.security.dto.JwtDto;
import com.cvillegas.app.main.security.dto.LoginDto;
import com.cvillegas.app.main.security.dto.UserDto;
import com.cvillegas.app.main.security.entity.Role;
import com.cvillegas.app.main.security.enums.RolName;
import com.cvillegas.app.main.security.jwt.JwtProvider;
import com.cvillegas.app.main.security.service.RolService;
import com.cvillegas.app.main.security.service.UserService;
import com.cvillegas.app.main.security.util.CookieUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RolService rolService;
    private final JwtProvider jwtProvider;

    @Value("${jwt.accessTokenCookieName:default}")
    private String cookieName;

    public AuthController(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, UserService usuarioService, RolService rolService, JwtProvider jwtProvider) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userService = usuarioService;
        this.rolService = rolService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/cmVnaXN0ZXI=")
    public ResponseEntity<Message> addNewUser(@Valid @RequestBody UserDto newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Information is not valid..."), HttpStatus.BAD_REQUEST);
        if (userService.existsByUsername(newUser.getUsername()) || userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity<>(new Message("This email/username is already registered..."), HttpStatus.BAD_REQUEST);

        User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolName.ROLE_USER).get());
        if (newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("Saved..."), HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(HttpServletResponse httpServletResponse, @Valid @RequestBody LoginDto loginUsuario, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Information is not valid..."), HttpStatus.BAD_REQUEST);
        }
        try  {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            JwtDto jwtDto = new JwtDto(HttpStatus.OK, jwt, userDetails.getUsername(), "Successfully logged", false, userDetails.getAuthorities());
            CookieUtil.create(httpServletResponse, cookieName, jwt, false, -1, "cvillegas-dev.com");
            return ResponseEntity.ok(jwtDto);
        } catch (Exception e) {
            String exception = "";

            if ( e.getCause() instanceof NoSuchElementException) {
                exception = "Error: User was not found.";
            } else {
                exception = e.getMessage();
            }

            JwtDto jwtDto = new JwtDto(HttpStatus.BAD_REQUEST, null, null, exception, false, null);
            return ResponseEntity.ok(jwtDto);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<Object> getUserDetails(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Optional<User> user= this.userService.getByUsername(userName);
        if (!user.isPresent())
            return new ResponseEntity<>(new Message("No encotrado"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user.get(), HttpStatus.OK) ;
    }
    @GetMapping("/logOut")
    public ResponseEntity<Message> logOut(HttpServletResponse httpServletResponse){
        CookieUtil.clear(httpServletResponse,cookieName);
        return new ResponseEntity<>(new Message("Sesión cerrada"), HttpStatus.OK) ;
    }
}