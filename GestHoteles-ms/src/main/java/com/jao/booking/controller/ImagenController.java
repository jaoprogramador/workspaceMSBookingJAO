package com.jao.booking.controller;

import com.jao.booking.model.ImagenDto;
import com.jao.booking.service.ImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
@RequiredArgsConstructor
public class ImagenController {

    private final ImagenService imagenService;

    @GetMapping
    public ResponseEntity<List<ImagenDto>> obtenerTodas() {
        return ResponseEntity.ok(imagenService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(imagenService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ImagenDto> crear(@RequestBody ImagenDto dto) {
        return ResponseEntity.ok(imagenService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenDto> actualizar(@PathVariable Long id, @RequestBody ImagenDto dto) {
        return ResponseEntity.ok(imagenService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        imagenService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

