package com.jao.booking.service;

import com.jao.booking.model.VehiculoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VehiculoService {
    Flux<VehiculoDTO> obtenerVehiculosDisponibles();
    Mono<VehiculoDTO> crearVehiculo(VehiculoDTO dto);
    Mono<VehiculoDTO> actualizarDisponibilidad(Long id, boolean disponible);
    Flux<VehiculoDTO> obtenerVehiculosPaginados(int page, int size, Boolean disponible);

}

