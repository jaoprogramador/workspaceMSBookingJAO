package com.jao.booking.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenDto {
    private Long id;
    private String url;
    private String descripcion;
    private Long habitacionId;
    private boolean activo;
}
