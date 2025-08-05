package com.jao.booking.model;


import com.jao.booking.enumEstado.EstadoVehiculo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String matricula;
    private String tipo;
    private int anio;
    private int kilometraje;
    private boolean disponible;
    private EstadoVehiculo estado;
    private Long sucursalId;
}

