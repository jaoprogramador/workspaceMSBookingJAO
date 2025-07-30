package com.jao.booking.controller;

import com.jao.booking.model.DireccionDto;
import com.jao.booking.service.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
@RequiredArgsConstructor
public class DireccionController {

    private final DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<DireccionDto>> obtenerTodas() {
        return ResponseEntity.ok(direccionService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(direccionService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<DireccionDto> crear(@RequestBody DireccionDto dto) {
        return ResponseEntity.ok(direccionService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionDto> actualizar(@PathVariable Long id, @RequestBody DireccionDto dto) {
        return ResponseEntity.ok(direccionService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        direccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
