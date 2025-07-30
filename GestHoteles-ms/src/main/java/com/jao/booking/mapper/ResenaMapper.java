package com.jao.booking.mapper;

import com.jao.booking.model.ResenaDto;
import com.jao.booking.entity.HotelEntity;
import com.jao.booking.entity.ResenaEntity;

public class ResenaMapper {

    public static ResenaDto toDto(ResenaEntity entity) {
        return ResenaDto.builder()
                .id(entity.getIdResena())
                .usuarioId(entity.getUsuarioId())
                .puntuacion(entity.getPuntuacion())
                .comentario(entity.getComentario())
                .fecha(entity.getFecha())
                .hotelId(entity.getHotel() != null ? entity.getHotel().getIdHotel() : null)
                .build();
    }

    public static ResenaEntity toEntity(ResenaDto dto, HotelEntity hotel) {
        return ResenaEntity.builder()
                .idResena(dto.getId())
                .usuarioId(dto.getUsuarioId())
                .puntuacion(dto.getPuntuacion())
                .comentario(dto.getComentario())
                .fecha(dto.getFecha())
                .hotel(hotel)
                .build();
    }
}

