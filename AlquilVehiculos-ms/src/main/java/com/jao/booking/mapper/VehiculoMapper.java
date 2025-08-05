package com.jao.booking.mapper;

import com.jao.booking.model.VehiculoDTO;
import com.jao.booking.entity.VehiculoEntity;
import com.jao.booking.entity.SucursalEntity;

public class VehiculoMapper {

    public static VehiculoDTO toDto(VehiculoEntity entity) {
        return VehiculoDTO.builder()
                .id(entity.getId())
                .marca(entity.getMarca())
                .modelo(entity.getModelo())
                .matricula(entity.getMatricula())
                .tipo(entity.getTipo())
                .anio(entity.getAnio())
                .kilometraje(entity.getKilometraje())
                .disponible(entity.isDisponible())
                .estado(entity.getEstado())
                .sucursalId(entity.getSucursal() != null ? entity.getSucursal().getId() : null)
                .build();
    }

    public static VehiculoEntity toEntity(VehiculoDTO dto, SucursalEntity sucursal) {
        return VehiculoEntity.builder()
                .id(dto.getId())
                .marca(dto.getMarca())
                .modelo(dto.getModelo())
                .matricula(dto.getMatricula())
                .tipo(dto.getTipo())
                .anio(dto.getAnio())
                .kilometraje(dto.getKilometraje())
                .disponible(dto.isDisponible())
                .estado(dto.getEstado())
                .sucursal(sucursal)
                .build();
    }
}

