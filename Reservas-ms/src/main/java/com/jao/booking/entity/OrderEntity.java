package com.jao.booking.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String orderCode;

    private Long usuarioId;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20)
    private EstadoOrden estado;

    private BigDecimal montoTotal;

    private String pagoId;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItemEntity> items;
}
