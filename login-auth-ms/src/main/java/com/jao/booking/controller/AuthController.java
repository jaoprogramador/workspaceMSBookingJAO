package com.jao.booking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jao.booking.model.LoginRequestDto;
import com.jao.booking.model.LoginResponseDto;
import com.jao.booking.service.AuthService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
        

    }
  //Iniciar sesión 
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request) {
    	log.info("Login-auth-ms:::ReservaController.login:::INI");
    	log.info("Petición de login para username={}", request.getUsername());

    	return authService.login(request);
    }
    
    
    
    //Cerrar sesión

}


