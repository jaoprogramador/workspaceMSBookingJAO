package com.jao.booking.mapper;

import com.jao.booking.entity.SucursalEntity;
import com.jao.booking.model.SucursalDTO;

public class SucursalMapper {

    public static SucursalDTO toDto(SucursalEntity entity) {
        return SucursalDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .direccion(entity.getDireccion())
                .ciudad(entity.getCiudad())
                .pais(entity.getPais())
                .build();
    }

    public static SucursalEntity toEntity(SucursalDTO dto) {
        return SucursalEntity.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .direccion(dto.getDireccion())
                .ciudad(dto.getCiudad())
                .pais(dto.getPais())
                .build();
    }
}

