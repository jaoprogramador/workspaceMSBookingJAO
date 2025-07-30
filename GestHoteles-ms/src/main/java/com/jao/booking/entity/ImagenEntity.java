package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;

    private String url;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private HabitacionEntity habitacion;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    private boolean activo;
}
