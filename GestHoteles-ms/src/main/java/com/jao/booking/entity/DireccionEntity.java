package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    private String calle;
    private String ciudad;
    private String provincia;
    private String pais;
    private String codigoPostal;
}
