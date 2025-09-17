package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "password_history")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PasswordHistoryEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private String oldPasswordHash;

    private LocalDateTime changedAt;
}

