package com.jao.booking.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jao.booking.model.SucursalDTO;
import com.jao.booking.model.VehiculoDTO;
import com.jao.booking.service.AlquilerVehiculosService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/alquiler")
public class AlquilerVehiculosController {

    private final AlquilerVehiculosService service;

    public AlquilerVehiculosController(AlquilerVehiculosService service) {
        this.service = service;
    }

    // --- Vehículos ---

    @GetMapping("/vehiculos")
    public Flux<VehiculoDTO> getAllVehiculos() {
        return service.getAllVehiculos();
    }

    @GetMapping("/vehiculos/{id}")
    public Mono<VehiculoDTO> getVehiculoById(@PathVariable Long id) {
        return service.getVehiculoById(id);
    }

    @PostMapping("/vehiculos")
    public Mono<VehiculoDTO> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        return service.saveVehiculo(vehiculoDTO);
    }

    @PutMapping("/vehiculos/{id}")
    public Mono<VehiculoDTO> updateVehiculo(@PathVariable Long id, @RequestBody VehiculoDTO vehiculoDTO) {
        // Actualizar el id en DTO por seguridad
        vehiculoDTO.setId(id);
        return service.saveVehiculo(vehiculoDTO);
    }

    @DeleteMapping("/vehiculos/{id}")
    public Mono<Void> deleteVehiculo(@PathVariable Long id) {
        return service.deleteVehiculo(id);
    }

    // --- Sucursales ---

    @GetMapping("/sucursales")
    public Flux<SucursalDTO> getAllSucursales() {
        return service.getAllSucursales();
    }

    @GetMapping("/sucursales/{id}")
    public Mono<SucursalDTO> getSucursalById(@PathVariable Long id) {
        return service.getSucursalById(id);
    }

    @PostMapping("/sucursales")
    public Mono<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursalDTO) {
        return service.saveSucursal(sucursalDTO);
    }

    @PutMapping("/sucursales/{id}")
    public Mono<SucursalDTO> updateSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
        sucursalDTO.setId(id);
        return service.saveSucursal(sucursalDTO);
    }

    @DeleteMapping("/sucursales/{id}")
    public Mono<Void> deleteSucursal(@PathVariable Long id) {
        return service.deleteSucursal(id);
    }
}
