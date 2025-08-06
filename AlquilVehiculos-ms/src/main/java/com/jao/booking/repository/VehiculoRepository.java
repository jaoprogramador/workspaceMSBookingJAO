package com.jao.booking.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.jao.booking.entity.VehiculoEntity;

import reactor.core.publisher.Flux;

public interface VehiculoRepository extends ReactiveCrudRepository<VehiculoEntity, Long> {
    Flux<VehiculoEntity> findBySucursalId(Long sucursalId);
}


