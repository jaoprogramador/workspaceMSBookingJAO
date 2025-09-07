package com.jao.booking.service;

import com.jao.booking.model.HotelDto;

import java.util.List;

public interface HotelService {
    List<HotelDto> obtenerTodos();
    HotelDto obtenerPorId(Long id);
    HotelDto crear(HotelDto dto);
    HotelDto actualizar(Long id, HotelDto dto);
    void eliminar(Long id);
    boolean tieneHabitacionesDisponibles(Long idHotel);
}
