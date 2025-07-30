package com.jao.booking.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "preferencias_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreferenciaUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idioma;
    private boolean recibirNotificaciones;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;
}
