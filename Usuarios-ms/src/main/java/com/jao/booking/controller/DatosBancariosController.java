package com.jao.booking.controller;

import com.jao.booking.model.DatosBancariosDTO;
import com.jao.booking.service.DatosBancariosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datos-bancarios")
public class DatosBancariosController {

    private final DatosBancariosService service;

    public DatosBancariosController(DatosBancariosService service) {
        this.service = service;
    }
    @Operation(summary = "Obtiene todos los Datos bancarios del usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de Datos bancarios de usuarios obtenido correctamente")
    })
    @GetMapping
    public List<DatosBancariosDTO> getAll() {
        return service.findAll();
    }
    @Operation(summary = "Obtiene datos bancarios por su ID")
    @GetMapping("/{id}")
    public DatosBancariosDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @Operation(summary = "Crea un nuevo datos bancarios")
    @PostMapping
    public DatosBancariosDTO create(@RequestBody DatosBancariosDTO dto) {
        return service.save(dto);
    }
    @Operation(summary = "Elimina los datos bancarios por ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
