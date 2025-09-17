package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "audit_logs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AuditLogEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private String action; // Ej: LOGIN_SUCCESS, LOGIN_FAIL, PASSWORD_CHANGED

    private LocalDateTime timestamp;

    private String ipAddress;
}

