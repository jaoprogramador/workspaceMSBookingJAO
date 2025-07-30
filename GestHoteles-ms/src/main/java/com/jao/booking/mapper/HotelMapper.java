package com.jao.booking.mapper;

import com.jao.booking.model.HotelDto;
import com.jao.booking.entity.HotelEntity;
import com.jao.booking.entity.ImagenEntity;

import java.util.stream.Collectors;

public class HotelMapper {

    public static HotelDto toDto(HotelEntity entity) {
        return HotelDto.builder()
                .id(entity.getIdHotel())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .categoria(entity.getCategoria())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())
                .web(entity.getWeb())
                .ciudad(entity.getDireccion() != null ? entity.getDireccion().getCiudad() : null)
                .activo(entity.isActivo())
                .imagenesUrls(entity.getImagenes() != null ?
                        entity.getImagenes().stream().map(ImagenEntity::getUrl).collect(Collectors.toList()) : null)
                .build();
    }

    public static HotelEntity toEntity(HotelDto dto) {
        return HotelEntity.builder()
                .idHotel(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .categoria(dto.getCategoria())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .web(dto.getWeb())
                .activo(dto.isActivo())
                .build();
    }
}
