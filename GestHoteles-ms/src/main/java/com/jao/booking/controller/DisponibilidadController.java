package com.jao.booking.controller;
import com.jao.booking.model.DisponibilidadDto;
import com.jao.booking.service.DisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidades")
@RequiredArgsConstructor
public class DisponibilidadController {

    private final DisponibilidadService disponibilidadService;

    @GetMapping
    public ResponseEntity<List<DisponibilidadDto>> obtenerTodas() {
        return ResponseEntity.ok(disponibilidadService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisponibilidadDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(disponibilidadService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<DisponibilidadDto> crear(@RequestBody DisponibilidadDto dto) {
        return ResponseEntity.ok(disponibilidadService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisponibilidadDto> actualizar(@PathVariable Long id, @RequestBody DisponibilidadDto dto) {
        return ResponseEntity.ok(disponibilidadService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        disponibilidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
