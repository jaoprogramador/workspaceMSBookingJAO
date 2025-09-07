package com.jao.booking.model;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String telefono;
    private String email;
    private String web;
    private String ciudad;
    private boolean activo;
    private List<String> imagenesUrls;
    private List<HabitacionDto> habitaciones;

}
