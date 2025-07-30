package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "habitaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;

    private String tipo;
    private String descripcion;
    private int capacidad;
    private double precioPorNoche;
    private String numeroHabitacion;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    private List<DisponibilidadEntity> disponibilidades;
}
