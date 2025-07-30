package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "hoteles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;

    private String nombre;
    private String descripcion;
    private String categoria;
    private String telefono;
    private String email;
    private String web;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private DireccionEntity direccion;

    private boolean activo;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<HabitacionEntity> habitaciones;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<ImagenEntity> imagenes;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<PoliticaEntity> politicas;
}
