package com.jao.booking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ReservaDTO {
    private Long id;
    private Long usuarioId;
    private LocalDateTime fechaCreacion;
    private String estado;
    private BigDecimal total;
    private String vueloId;
    private String hotelId;
    private String vehiculoId;
    private String actividadId;
    private String pagoId;

    // Getters y setters o usa Lombok (@Data)
}

