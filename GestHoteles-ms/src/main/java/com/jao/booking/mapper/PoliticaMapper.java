package com.jao.booking.mapper;

import com.jao.booking.entity.HotelEntity;
import com.jao.booking.entity.PoliticaEntity;
import com.jao.booking.model.PoliticaDto;
public class PoliticaMapper {

    public static PoliticaDto toDto(PoliticaEntity entity) {
        return PoliticaDto.builder()
                .id(entity.getIdPolitica())
                .tipo(entity.getTipo())
                .descripcion(entity.getDescripcion())
                .hotelId(entity.getHotel() != null ? entity.getHotel().getIdHotel() : null)
                .build();
    }

    public static PoliticaEntity toEntity(PoliticaDto dto, HotelEntity hotel) {
        return PoliticaEntity.builder()
                .idPolitica(dto.getId())
                .tipo(dto.getTipo())
                .descripcion(dto.getDescripcion())
                .hotel(hotel)
                .build();
    }
}

