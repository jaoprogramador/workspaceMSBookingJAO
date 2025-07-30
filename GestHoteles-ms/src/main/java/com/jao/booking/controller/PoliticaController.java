package com.jao.booking.controller;

import com.jao.booking.model.PoliticaDto;
import com.jao.booking.service.PoliticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/politicas")
@RequiredArgsConstructor
public class PoliticaController {

    private final PoliticaService politicaService;

    @GetMapping
    public ResponseEntity<List<PoliticaDto>> obtenerTodas() {
        return ResponseEntity.ok(politicaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliticaDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(politicaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<PoliticaDto> crear(@RequestBody PoliticaDto dto) {
        return ResponseEntity.ok(politicaService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoliticaDto> actualizar(@PathVariable Long id, @RequestBody PoliticaDto dto) {
        return ResponseEntity.ok(politicaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        politicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

