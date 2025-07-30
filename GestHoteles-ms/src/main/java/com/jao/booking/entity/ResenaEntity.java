package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resenas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResenaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResena;

    private Long usuarioId;
    private int puntuacion;
    private String comentario;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;
}