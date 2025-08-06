package com.jao.booking.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("vehiculos")
public class VehiculoEntity {

	@Id
    private Long id;
    private String marca;
    private String modelo;
    private int año;
    private Long sucursalId;
    private boolean disponible;
}


