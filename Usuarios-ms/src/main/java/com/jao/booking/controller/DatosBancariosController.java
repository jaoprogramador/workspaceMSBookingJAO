package com.jao.booking.controller;

import com.jao.booking.model.DatosBancariosDTO;
import com.jao.booking.service.DatosBancariosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datos-bancarios")
public class DatosBancariosController {

    private final DatosBancariosService service;

    public DatosBancariosController(DatosBancariosService service) {
        this.service = service;
    }

    @GetMapping
    public List<DatosBancariosDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DatosBancariosDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DatosBancariosDTO create(@RequestBody DatosBancariosDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
