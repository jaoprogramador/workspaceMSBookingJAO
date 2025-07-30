package com.jao.booking.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatosBancariosDTO {
    private Long id;
    private String titular;
    private String numeroCuenta;
    private String banco;
    private String swiftBic;
    private String tipoCuenta;
    private boolean activo;
}
