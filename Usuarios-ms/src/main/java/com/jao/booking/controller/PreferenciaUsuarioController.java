package com.jao.booking.controller;

import com.jao.booking.model.PreferenciaUsuarioDTO;
import com.jao.booking.service.PreferenciaUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferencias-usuario")
public class PreferenciaUsuarioController {

    private final PreferenciaUsuarioService service;

    public PreferenciaUsuarioController(PreferenciaUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<PreferenciaUsuarioDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PreferenciaUsuarioDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PreferenciaUsuarioDTO create(@RequestBody PreferenciaUsuarioDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}