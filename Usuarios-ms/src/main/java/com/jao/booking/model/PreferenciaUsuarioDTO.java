package com.jao.booking.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreferenciaUsuarioDTO {
    private Long id;
    private String idioma;
    private boolean recibirNotificaciones;
}
