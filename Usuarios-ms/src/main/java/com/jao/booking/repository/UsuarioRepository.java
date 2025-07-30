package com.jao.booking.repository;

import com.jao.booking.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}