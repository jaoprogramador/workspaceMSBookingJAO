package com.jao.booking.dto;
import lombok.*;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservaNotificadaDTO {
    private Long reservaId;
    private Long usuarioId;
    private BigDecimal total;
    private String mensaje;
    private TipoNotificacion tipo;
}


