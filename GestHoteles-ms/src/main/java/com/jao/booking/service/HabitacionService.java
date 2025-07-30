package com.jao.booking.service;

import com.jao.booking.model.HabitacionDto;

import java.util.List;

public interface HabitacionService {
    List<HabitacionDto> obtenerTodas();
    HabitacionDto obtenerPorId(Long id);
    HabitacionDto crear(HabitacionDto dto);
    HabitacionDto actualizar(Long id, HabitacionDto dto);
    void eliminar(Long id);
}
