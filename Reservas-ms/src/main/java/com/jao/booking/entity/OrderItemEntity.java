package com.jao.booking.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orden_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con la orden principal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id", nullable = false)
    private OrderEntity orden;

    @Enumerated(EnumType.STRING)
    private TipoItem tipo; // VUELO, HOTEL, VEHICULO, ACTIVIDAD

    private String referenciaReservaId; // ID externo (reserva de vuelo, hotel, etc.)

    private BigDecimal precio;

    private String descripcion; // opcional: nombre del hotel, vuelo, etc.
}

