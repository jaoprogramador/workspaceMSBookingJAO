package com.jao.booking.service;

import com.jao.booking.model.ResenaDto;

import java.util.List;

public interface ResenaService {
    List<ResenaDto> obtenerTodas();
    ResenaDto obtenerPorId(Long id);
    ResenaDto crear(ResenaDto dto);
    ResenaDto actualizar(Long id, ResenaDto dto);
    void eliminar(Long id);
}

