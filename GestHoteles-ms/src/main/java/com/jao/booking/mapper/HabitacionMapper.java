package com.jao.booking.mapper;

import com.jao.booking.model.HabitacionDto;

import java.util.Collections;
import java.util.stream.Collectors;

import com.jao.booking.entity.HabitacionEntity;
import com.jao.booking.entity.HotelEntity;

public class HabitacionMapper {

	public static HabitacionDto toDto(HabitacionEntity entity) {
        return HabitacionDto.builder()
                .id(entity.getIdHabitacion())
                .tipo(entity.getTipo())
                .descripcion(entity.getDescripcion())
                .capacidad(entity.getCapacidad())
                .precioPorNoche(entity.getPrecioPorNoche())
                .numeroHabitacion(entity.getNumeroHabitacion())
                .hotelId(entity.getHotel() != null ? entity.getHotel().getIdHotel() : null)
                .disponibilidades(entity.getDisponibilidades() != null
                        ? entity.getDisponibilidades().stream()
                            .map(DisponibilidadMapper::toDto)
                            .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }

    // Mapea de DTO a entidad, estableciendo la relación con el hotel
    public static HabitacionEntity toEntity(HabitacionDto dto, HotelEntity hotel) {
        return HabitacionEntity.builder()
                .idHabitacion(dto.getId())
                .tipo(dto.getTipo())
                .descripcion(dto.getDescripcion())
                .capacidad(dto.getCapacidad())
                .precioPorNoche(dto.getPrecioPorNoche())
                .numeroHabitacion(dto.getNumeroHabitacion())
                .hotel(hotel)
                .build();
    }

}

