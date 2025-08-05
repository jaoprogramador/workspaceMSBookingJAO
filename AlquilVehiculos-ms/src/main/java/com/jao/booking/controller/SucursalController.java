package com.jao.booking.controller;

import com.jao.booking.model.SucursalDTO;
import com.jao.booking.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping
    public Mono<SucursalDTO> crear(@RequestBody SucursalDTO dto) {
        return sucursalService.crearSucursal(dto);
    }

    @GetMapping
    public Flux<SucursalDTO> listarTodas() {
        return sucursalService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Mono<SucursalDTO> obtenerPorId(@PathVariable Long id) {
        return sucursalService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Mono<SucursalDTO> actualizar(@PathVariable Long id, @RequestBody SucursalDTO dto) {
        return sucursalService.actualizarSucursal(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable Long id) {
        return sucursalService.eliminarSucursal(id);
    }
}

