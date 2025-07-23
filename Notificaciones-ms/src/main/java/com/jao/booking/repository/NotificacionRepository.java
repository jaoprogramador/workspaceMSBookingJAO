package com.jao.booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.booking.entity.NotificacionEntity;

@Repository
public interface NotificacionRepository extends JpaRepository<NotificacionEntity, Long> {
}

