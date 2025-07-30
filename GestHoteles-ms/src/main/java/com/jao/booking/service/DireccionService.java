package com.jao.booking.service;

import com.jao.booking.model.DireccionDto;

import java.util.List;

public interface DireccionService {
    List<DireccionDto> obtenerTodos();
    DireccionDto obtenerPorId(Long id);
    DireccionDto crear(DireccionDto dto);
    DireccionDto actualizar(Long id, DireccionDto dto);
    void eliminar(Long id);
}

