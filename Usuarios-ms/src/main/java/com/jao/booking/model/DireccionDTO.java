package com.jao.booking.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DireccionDTO {
    private Long id;
    private String calle;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private String pais;
}
