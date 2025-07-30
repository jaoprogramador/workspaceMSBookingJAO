package com.jao.booking.mapper;

import com.jao.booking.model.ImagenDto;
import com.jao.booking.entity.HabitacionEntity;
import com.jao.booking.entity.ImagenEntity;

public class ImagenMapper {

    public static ImagenDto toDto(ImagenEntity entity) {
        return ImagenDto.builder()
                .id(entity.getIdImagen())
                .url(entity.getUrl())
                .descripcion(entity.getDescripcion())
                .habitacionId(entity.getHabitacion() != null ? entity.getHabitacion().getIdHabitacion() : null)
                .activo(entity.isActivo())
                .build();
    }

    public static ImagenEntity toEntity(ImagenDto dto, HabitacionEntity habitacion) {
        return ImagenEntity.builder()
                .idImagen(dto.getId())
                .url(dto.getUrl())
                .descripcion(dto.getDescripcion())
                .habitacion(habitacion)
                .activo(dto.isActivo())
                .build();
    }
}
