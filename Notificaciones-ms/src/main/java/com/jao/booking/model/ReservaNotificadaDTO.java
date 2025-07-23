package com.jao.booking.model;
import lombok.*;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaNotificadaDTO {
    private Long reservaId;
    private Long usuarioId;
    private BigDecimal total;
    private String mensaje;
    private String destinatario;
    private TipoNotificacion tipo;

}


