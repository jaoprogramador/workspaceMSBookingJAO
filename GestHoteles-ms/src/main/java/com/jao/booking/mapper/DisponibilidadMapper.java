package com.jao.booking.mapper;

import com.jao.booking.model.DisponibilidadDto;
import com.jao.booking.entity.DisponibilidadEntity;
import com.jao.booking.entity.HabitacionEntity;

public class DisponibilidadMapper {

    public static DisponibilidadDto toDto(DisponibilidadEntity entity) {
        return DisponibilidadDto.builder()
                .id(entity.getId())
                .habitacionId(entity.getHabitacion().getIdHabitacion())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .disponible(entity.isDisponible())
                .build();
    }

    public static DisponibilidadEntity toEntity(DisponibilidadDto dto, HabitacionEntity habitacion) {
        return DisponibilidadEntity.builder()
                .id(dto.getId())
                .habitacion(habitacion)
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .disponible(dto.isDisponible())
                .build();
    }
}
