package com.jao.booking.entity;
import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Data // incluye @Getter, @Setter, @ToString, @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder // para usar patrón builder en instanciación

public class ReservaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    private BigDecimal total;

    // Referencias a reservas en otros microservicios
    private String vueloId;
    private String hotelId;
    private String vehiculoId;
    private String actividadId;

    private String pagoId;
}
