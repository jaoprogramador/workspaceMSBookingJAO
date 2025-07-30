package com.jao.booking.controller;

import com.jao.booking.model.DireccionDTO;
import com.jao.booking.service.DireccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<DireccionDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DireccionDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DireccionDTO create(@RequestBody DireccionDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
