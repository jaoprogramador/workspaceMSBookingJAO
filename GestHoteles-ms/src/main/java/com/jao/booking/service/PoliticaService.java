package com.jao.booking.service;

import com.jao.booking.model.PoliticaDto;

import java.util.List;

public interface PoliticaService {
    List<PoliticaDto> obtenerTodas();
    PoliticaDto obtenerPorId(Long id);
    PoliticaDto crear(PoliticaDto dto);
    PoliticaDto actualizar(Long id, PoliticaDto dto);
    void eliminar(Long id);
}

