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
@Table("sucursales")
public class SucursalEntity {

    @Id
    private Long id;

    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private String telefono;
}


