package com.jao.booking.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimaModificacion;
    private String rol;
    private boolean activo;
    private List<DatosBancariosDTO> datosBancarios;
}
