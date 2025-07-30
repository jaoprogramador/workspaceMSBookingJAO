package com.jao.booking.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email; // Identificador compartido con login-auth-MS

    private String telefono;

    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimaModificacion;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatosBancariosEntity> datosBancarios;
    
    private boolean activo;
    
}
