package com.jao.booking.controller;

import com.jao.booking.model.HabitacionDto;
import com.jao.booking.service.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {

    private final HabitacionService habitacionService;

    @GetMapping
    public ResponseEntity<List<HabitacionDto>> obtenerTodas() {
        return ResponseEntity.ok(habitacionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(habitacionService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<HabitacionDto> crear(@RequestBody HabitacionDto dto) {
        return ResponseEntity.ok(habitacionService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitacionDto> actualizar(@PathVariable Long id, @RequestBody HabitacionDto dto) {
        return ResponseEntity.ok(habitacionService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        habitacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

