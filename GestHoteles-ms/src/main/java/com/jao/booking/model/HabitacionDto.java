package com.jao.booking.model;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionDto {
    private Long id;
    private String tipo;
    private String descripcion;
    private int capacidad;
    private double precioPorNoche;
    private String numeroHabitacion;
    private Long hotelId;
    private List<DisponibilidadDto> disponibilidades; 
}
