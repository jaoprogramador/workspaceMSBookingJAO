package com.jao.booking.mapper;

import com.jao.booking.model.DireccionDto;
import com.jao.booking.entity.DireccionEntity;

public class DireccionMapper {

    public static DireccionDto toDto(DireccionEntity entity) {
        return DireccionDto.builder()
                .id(entity.getIdDireccion())
                .calle(entity.getCalle())
                .ciudad(entity.getCiudad())
                .provincia(entity.getProvincia())
                .codigoPostal(entity.getCodigoPostal())
                .pais(entity.getPais())
                .build();
    }

    public static DireccionEntity toEntity(DireccionDto dto) {
        return DireccionEntity.builder()
                .idDireccion(dto.getId())
                .calle(dto.getCalle())
                .ciudad(dto.getCiudad())
                .provincia(dto.getProvincia())
                .codigoPostal(dto.getCodigoPostal())
                .pais(dto.getPais())
                .build();
    }
}
