package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "datos_bancarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatosBancariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;

    private String numeroCuenta; // o IBAN
    private String banco;
    private String swiftBic; // opcional, útil para transferencias internacionales

    private String tipoCuenta; // Corriente, Ahorros, etc. (también puede ser un Enum)

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    private boolean activo; // por si se permite tener varias cuentas
}

