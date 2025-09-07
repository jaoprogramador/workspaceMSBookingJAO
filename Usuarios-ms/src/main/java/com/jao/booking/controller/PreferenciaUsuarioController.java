package com.jao.booking.controller;

import com.jao.booking.model.PreferenciaUsuarioDTO;
import com.jao.booking.service.PreferenciaUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferencias-usuario")
public class PreferenciaUsuarioController {

    private final PreferenciaUsuarioService service;

    public PreferenciaUsuarioController(PreferenciaUsuarioService service) {
        this.service = service;
    }
    
    @Operation(summary = "Obtiene todos las preferencias del usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de preferencias de usuarios obtenido correctamente")
    })

    @GetMapping
    public List<PreferenciaUsuarioDTO> getAll() {
        return service.findAll();
    }
    @Operation(summary = "Obtiene la preferencia por su ID")
    @GetMapping("/{id}")
    public PreferenciaUsuarioDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @Operation(summary = "crea la preferencia nueva")
    @PostMapping
    public PreferenciaUsuarioDTO create(@RequestBody PreferenciaUsuarioDTO dto) {
        return service.save(dto);
    }
    @Operation(summary = "Borra la preferencia por su ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}