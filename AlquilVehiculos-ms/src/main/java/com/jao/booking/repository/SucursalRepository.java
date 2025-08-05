package com.jao.booking.repository;

import com.jao.booking.entity.SucursalEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SucursalRepository extends ReactiveCrudRepository<SucursalEntity, Long> {
}
