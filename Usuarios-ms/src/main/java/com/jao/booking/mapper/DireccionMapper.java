package com.jao.booking.mapper;

import com.jao.booking.model.DireccionDTO;
import com.jao.booking.entity.DireccionEntity;
import org.springframework.stereotype.Component;

@Component
public class DireccionMapper {

    public DireccionDTO toDTO(DireccionEntity entity) {
        return DireccionDTO.builder()
                .id(entity.getId())
                .calle(entity.getCalle())
                .ciudad(entity.getCiudad())
                .provincia(entity.getProvincia())
                .codigoPostal(entity.getCodigoPostal())
                .pais(entity.getPais())
                .build();
    }

    public DireccionEntity toEntity(DireccionDTO dto) {
        return DireccionEntity.builder()
                .id(dto.getId())
                .calle(dto.getCalle())
                .ciudad(dto.getCiudad())
                .provincia(dto.getProvincia())
                .codigoPostal(dto.getCodigoPostal())
                .pais(dto.getPais())
                .build();
    }
}
