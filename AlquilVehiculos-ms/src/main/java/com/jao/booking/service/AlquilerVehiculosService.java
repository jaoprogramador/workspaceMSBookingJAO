package com.jao.booking.service;

import com.jao.booking.model.SucursalDTO;
import com.jao.booking.model.VehiculoDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlquilerVehiculosService {

    // Vehículos
    Flux<VehiculoDTO> getAllVehiculos();

    Mono<VehiculoDTO> getVehiculoById(Long id);

    Mono<VehiculoDTO> saveVehiculo(VehiculoDTO vehiculoDTO);

    Mono<Void> deleteVehiculo(Long id);

    // Sucursales
    Flux<SucursalDTO> getAllSucursales();

    Mono<SucursalDTO> getSucursalById(Long id);

    Mono<SucursalDTO> saveSucursal(SucursalDTO sucursalDTO);

    Mono<Void> deleteSucursal(Long id);
}
