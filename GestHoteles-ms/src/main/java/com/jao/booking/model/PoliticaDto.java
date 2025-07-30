package com.jao.booking.model;

import com.jao.booking.enums.TipoPolitica;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoliticaDto {
    private Long id;
    private TipoPolitica tipo;
    private String descripcion;
    private Long hotelId;
}

