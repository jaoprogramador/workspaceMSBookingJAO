package com.jao.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "permissions")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PermissionEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name; // Ej: CAN_UPDATE_PASSWORD

    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<RoleEntity> roles;
}

