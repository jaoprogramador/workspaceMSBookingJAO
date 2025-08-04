package com.jao.booking.entity;

import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String matricula;
    private String tipo; // SUV, Sedán, etc.
    private int anio;
    private int kilometraje;
    private boolean disponible;

    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado; // NUEVO, USADO, MANTENIMIENTO

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private SucursalEntity sucursal;
}


