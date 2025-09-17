package com.jao.booking.controller;

import com.jao.booking.model.CreateUserRequest;
import com.jao.booking.model.PasswordChangeRequestDto;
import com.jao.booking.model.UserDto;
import com.jao.booking.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/api/login")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Obtiene todos los usuarios")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de usuarios obtenido correctamente")
    })
    
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAllUsers();
    }
    
    @Operation(summary = "Obtiene un usuario por su ID")
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable UUID id) {
    	log.info("Login-auth-ms:::UserController.getById:::INI");
        return userService.getUserById(id);
    }

    @Operation(summary = "Cambia la password de un usuario")
    @PatchMapping("/{id}/password")
    public void changePassword(@PathVariable UUID id, @RequestBody PasswordChangeRequestDto request) {
        userService.changePassword(id, request);
    }
    
    //crear usuario
    @Operation(summary = "Crea un usuario")
    @PostMapping("/create-user")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
    	log.info("Login-auth-ms:::UserController.createUser:::INI");
    	log.info("Petición de crearusuario username={}", request.getUser().getUsername());
        UserDto createdUser = userService.createUser(request.getUser(), request.getPassword());
        log.info("Usuario creado", "");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    //actualizar usuario completo
    //borrar usuario
}

