package com.jao.booking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jao.booking.model.UsuarioDTO;
import com.jao.booking.service.UsuarioProducerEvent;
import com.jao.booking.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioProducerEvent producer;

    public UsuarioController(UsuarioService service, UsuarioProducerEvent producer) {
        this.service = service;
        this.producer = producer;
    }

    @Operation(summary = "Obtiene todos los usuarios")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de usuarios obtenido correctamente")
    })
    @GetMapping
    public List<UsuarioDTO> getAll() {
        return service.findAll();
    }

    @Operation(summary = "Obtiene un usuario por su ID")
    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @Operation(summary = "Crea un nuevo usuario")
    @PostMapping
    public UsuarioDTO create(@RequestBody UsuarioDTO dto) {
    	producer.enviarUsuarioCreado(dto);  
    	return service.save(dto);
        
    }
    @Operation(summary = "Elimina un usuario por ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
