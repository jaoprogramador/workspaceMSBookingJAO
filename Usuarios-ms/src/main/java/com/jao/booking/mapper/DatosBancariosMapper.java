package com.jao.booking.mapper;

import com.jao.booking.model.DatosBancariosDTO;
import com.jao.booking.entity.DatosBancariosEntity;
import org.springframework.stereotype.Component;

@Component
public class DatosBancariosMapper {

    public DatosBancariosDTO toDTO(DatosBancariosEntity entity) {
        return DatosBancariosDTO.builder()
                .id(entity.getId())
                .titular(entity.getTitular())
                .numeroCuenta(entity.getNumeroCuenta())
                .banco(entity.getBanco())
                .swiftBic(entity.getSwiftBic())
                .tipoCuenta(entity.getTipoCuenta())
                .activo(entity.isActivo())
                .build();
    }

    public DatosBancariosEntity toEntity(DatosBancariosDTO dto) {
        return DatosBancariosEntity.builder()
                .id(dto.getId())
                .titular(dto.getTitular())
                .numeroCuenta(dto.getNumeroCuenta())
                .banco(dto.getBanco())
                .swiftBic(dto.getSwiftBic())
                .tipoCuenta(dto.getTipoCuenta())
                .activo(dto.isActivo())
                .build();
    }
}
