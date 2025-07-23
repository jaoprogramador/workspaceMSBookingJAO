package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jao.booking.model.TipoNotificacion;

@Entity
@Table(name = "notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long reservaId;
    private Long usuarioId;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoNotificacion tipo;

    private String mensaje;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoNotificacion estado;

    private String destinatario;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaEnvio;

    private String error; // mensaje de error si falló
}

