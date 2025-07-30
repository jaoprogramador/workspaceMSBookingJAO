package com.jao.booking.mapper;

import com.jao.booking.model.PreferenciaUsuarioDTO;
import com.jao.booking.entity.PreferenciaUsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class PreferenciaUsuarioMapper {

    public PreferenciaUsuarioDTO toDTO(PreferenciaUsuarioEntity entity) {
        return PreferenciaUsuarioDTO.builder()
                .id(entity.getId())
                .idioma(entity.getIdioma())
                .recibirNotificaciones(entity.isRecibirNotificaciones())
                .build();
    }

    public PreferenciaUsuarioEntity toEntity(PreferenciaUsuarioDTO dto) {
        return PreferenciaUsuarioEntity.builder()
                .id(dto.getId())
                .idioma(dto.getIdioma())
                .recibirNotificaciones(dto.isRecibirNotificaciones())
                .build();
    }
}