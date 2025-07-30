package com.jao.booking.controller;

import com.jao.booking.model.ResenaDto;
import com.jao.booking.service.ResenaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resenas")
@RequiredArgsConstructor
public class ResenaController {

    private final ResenaService resenaService;

    @GetMapping
    public ResponseEntity<List<ResenaDto>> obtenerTodas() {
        return ResponseEntity.ok(resenaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResenaDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(resenaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ResenaDto> crear(@RequestBody ResenaDto dto) {
        return ResponseEntity.ok(resenaService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResenaDto> actualizar(@PathVariable Long id, @RequestBody ResenaDto dto) {
        return ResponseEntity.ok(resenaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        resenaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
