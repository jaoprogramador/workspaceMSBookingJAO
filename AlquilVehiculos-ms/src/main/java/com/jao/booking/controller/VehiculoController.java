package com.jao.booking.controller;

import com.jao.booking.model.VehiculoDTO;
import com.jao.booking.service.VehiculoService;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping(value = "/disponibles", produces = MediaType.TEXT_EVENT_STREAM_VALUE)

    public Flux<VehiculoDTO> listarDisponibles() {
        return vehiculoService.obtenerVehiculosDisponibles().delayElements(Duration.ofMillis(500));
    }

    @PostMapping
    public Mono<VehiculoDTO> crear(@RequestBody VehiculoDTO dto) {
        return vehiculoService.crearVehiculo(dto);
    }

    @PatchMapping("/{id}/disponibilidad")
    public Mono<VehiculoDTO> actualizarDisponibilidad(@PathVariable Long id, @RequestParam boolean disponible) {
        return vehiculoService.actualizarDisponibilidad(id, disponible);
    }
    @GetMapping
    public Flux<VehiculoDTO> listarPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Boolean disponible
    ) {
        return vehiculoService.obtenerVehiculosPaginados(page, size, disponible);
    }
}

