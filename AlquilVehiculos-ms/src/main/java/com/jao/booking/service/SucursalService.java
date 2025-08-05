package com.jao.booking.service;

import com.jao.booking.model.SucursalDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SucursalService {
    Mono<SucursalDTO> crearSucursal(SucursalDTO dto);
    Flux<SucursalDTO> obtenerTodas();
    Mono<SucursalDTO> obtenerPorId(Long id);
    Mono<SucursalDTO> actualizarSucursal(Long id, SucursalDTO dto);
    Mono<Void> eliminarSucursal(Long id);
}

