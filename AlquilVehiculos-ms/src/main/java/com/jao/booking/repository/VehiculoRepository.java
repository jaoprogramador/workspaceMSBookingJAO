package com.jao.booking.repository;

import com.jao.booking.entity.VehiculoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface VehiculoRepository extends ReactiveCrudRepository<VehiculoEntity, Long> {
    Flux<VehiculoEntity> findByDisponibleTrue();
    Flux<VehiculoEntity> findByDisponible(boolean disponible);

}

