package com.jao.booking.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.jao.booking.entity.SucursalEntity;

public interface SucursalRepository extends ReactiveCrudRepository<SucursalEntity, Long> {
}
