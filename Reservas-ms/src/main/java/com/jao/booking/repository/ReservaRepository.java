package com.jao.booking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.booking.entity.EstadoReserva;
import com.jao.booking.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByUsuarioId(Long usuarioId);
    
    Optional <ReservaEntity> findById(Long id);
    
    @Query("SELECT r FROM ReservaEntity r WHERE r.fechaCreacion BETWEEN :start AND :end")
    List<ReservaEntity> findReservasBetweenDates(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
    
    List<ReservaEntity> findByEstado(EstadoReserva estado); 
}
