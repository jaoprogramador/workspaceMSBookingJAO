package com.jao.booking.controller;

import com.jao.booking.model.DireccionDTO;
import com.jao.booking.service.DireccionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }
    @Operation(summary = "Obtiene todos los Datos de la dirección del usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de direccións de usuarios obtenido correctamente")
    })
    
    @GetMapping
    public List<DireccionDTO> getAll() {
        return service.findAll();
    }
    @Operation(summary = "Obtiene la dirección por su ID")
    @GetMapping("/{id}")
    public DireccionDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @Operation(summary = "Crea un nuevo dirección")
    @PostMapping
    public DireccionDTO create(@RequestBody DireccionDTO dto) {
        return service.save(dto);
    }
    @Operation(summary = "Elimina los datos de la dirección por ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
