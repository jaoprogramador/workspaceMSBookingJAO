package com.jao.booking.mapper;

import com.jao.booking.entity.*;
import com.jao.booking.model.*;
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
                        entity.getImagenes().stream()
                            .map(ImagenEntity::getUrl)
                            .collect(Collectors.toList()) : null)
                .habitaciones(entity.getHabitaciones() != null ?
                        entity.getHabitaciones().stream()
                                .map(HabitacionMapper::toDto)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    public static HotelEntity toEntity(HotelDto dto) {
        HotelEntity hotel = HotelEntity.builder()
                .idHotel(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .categoria(dto.getCategoria())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .web(dto.getWeb())
                .activo(dto.isActivo())
                .build();

        if (dto.getHabitaciones() != null) {
            hotel.setHabitaciones(
                dto.getHabitaciones().stream()
                   .map(habitacionDto -> HabitacionMapper.toEntity(habitacionDto, hotel))
                   .collect(Collectors.toList())
            );
        }

        return hotel;
    }
}

