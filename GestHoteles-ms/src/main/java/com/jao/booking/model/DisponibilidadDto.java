package com.jao.booking.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisponibilidadDto {
    private Long id;
    private Long habitacionId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean disponible;
}
