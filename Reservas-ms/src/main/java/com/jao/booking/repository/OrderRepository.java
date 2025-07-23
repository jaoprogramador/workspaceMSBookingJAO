package com.jao.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jao.booking.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
