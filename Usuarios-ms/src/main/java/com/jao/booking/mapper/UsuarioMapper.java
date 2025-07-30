package com.jao.booking.mapper;

import com.jao.booking.model.UsuarioDTO;
import com.jao.booking.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO(UsuarioEntity entity) {
        return UsuarioDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .email(entity.getEmail())
                .telefono(entity.getTelefono())
                .fechaRegistro(entity.getFechaRegistro())
                .ultimaModificacion(entity.getUltimaModificacion())
                .rol(entity.getRol().name())
                .activo(entity.isActivo())
                .build();
    }

    public UsuarioEntity toEntity(UsuarioDTO dto) {
        return UsuarioEntity.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .fechaRegistro(dto.getFechaRegistro())
                .ultimaModificacion(dto.getUltimaModificacion())
                .activo(dto.isActivo())
                .build();
    }
}