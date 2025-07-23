package com.jao.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.booking.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByUsuarioId(Long usuarioId);
    
    Optional <ReservaEntity> findById(Long id);
}
