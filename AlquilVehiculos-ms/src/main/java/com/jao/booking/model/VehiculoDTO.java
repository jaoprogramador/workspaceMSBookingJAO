package com.jao.booking.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoDTO {
	private Long id;
    private String marca;
    private String modelo;
    private int año;
    private Long sucursalId;
    private boolean disponible;

}

