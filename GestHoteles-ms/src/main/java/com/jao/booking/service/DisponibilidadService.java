package com.jao.booking.service;

import com.jao.booking.model.DisponibilidadDto;

import java.util.List;

public interface DisponibilidadService {
    List<DisponibilidadDto> obtenerTodas();
    DisponibilidadDto obtenerPorId(Long id);
    DisponibilidadDto crear(DisponibilidadDto dto);
    DisponibilidadDto actualizar(Long id, DisponibilidadDto dto);
    void eliminar(Long id);
}
