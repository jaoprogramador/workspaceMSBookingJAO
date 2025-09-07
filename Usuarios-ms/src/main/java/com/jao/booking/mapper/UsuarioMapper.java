package com.jao.booking.mapper;

import com.jao.booking.model.DatosBancariosDTO;
import com.jao.booking.model.UsuarioDTO;
import com.jao.booking.entity.DatosBancariosEntity;
import com.jao.booking.entity.UsuarioEntity;

import java.util.List;
import java.util.stream.Collectors;

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
                .datosBancarios(
                        entity.getDatosBancarios() != null ?
                            entity.getDatosBancarios().stream().map(dato ->
                                    DatosBancariosDTO.builder()
                                            .id(dato.getId())
                                            .titular(dato.getTitular())
                                            .numeroCuenta(dato.getNumeroCuenta())
                                            .banco(dato.getBanco())
                                            .swiftBic(dato.getSwiftBic())
                                            .tipoCuenta(dato.getTipoCuenta())
                                            .activo(dato.isActivo())
                                            .build()
                            ).collect(Collectors.toList())
                            : null
                )
                .build();

    }

    public UsuarioEntity toEntity(UsuarioDTO dto) {
        UsuarioEntity usuario = UsuarioEntity.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .fechaRegistro(dto.getFechaRegistro())
                .ultimaModificacion(dto.getUltimaModificacion())
                .activo(dto.isActivo())
                .build();

        if (dto.getDatosBancarios() != null) {
            List<DatosBancariosEntity> datosBancariosEntities = dto.getDatosBancarios().stream()
                    .map(datoDto -> {
                        DatosBancariosEntity entity = DatosBancariosEntity.builder()
                                .id(datoDto.getId())
                                .titular(datoDto.getTitular())
                                .numeroCuenta(datoDto.getNumeroCuenta())
                                .banco(datoDto.getBanco())
                                .swiftBic(datoDto.getSwiftBic())
                                .tipoCuenta(datoDto.getTipoCuenta())
                                .activo(datoDto.isActivo())
                                .usuario(usuario) // 👈 Importante
                                .build();
                        return entity;
                    })
                    .collect(Collectors.toList());

            usuario.setDatosBancarios(datosBancariosEntities);
        }

        return usuario;
    }

}