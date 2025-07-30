package com.jao.booking.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResenaDto {
    private Long id;
    private Long usuarioId;
    private int puntuacion;
    private String comentario;
    private LocalDateTime fecha;
    private Long hotelId;
}

