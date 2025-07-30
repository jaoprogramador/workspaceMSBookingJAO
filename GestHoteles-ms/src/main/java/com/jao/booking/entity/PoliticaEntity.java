package com.jao.booking.entity;

import com.jao.booking.enums.TipoPolitica;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "politicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoliticaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPolitica;

    @Enumerated(EnumType.STRING)
    private TipoPolitica tipo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;
}
