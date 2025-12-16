package com.vimarsh.auth_service.controller;

import com.vimarsh.auth_service.dto.LoginRequestDTO;
import com.vimarsh.auth_service.dto.LoginResponseDTO;
import com.vimarsh.auth_service.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Tag(name= "User Auth APIs")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService ;

    public AuthController(AuthService authService){
        this.authService = authService ;
    }

    @GetMapping
    public ResponseEntity<LoginResponseDTO> UserLoginCheck(@RequestBody LoginRequestDTO loginRequestDTO){
        Optional<String> token= authService.Authenticate(loginRequestDTO) ;
        return token.map(s -> ResponseEntity.ok().body(new LoginResponseDTO(s))).orElseGet(() ->
                ResponseEntity.notFound().build());
    }
}
