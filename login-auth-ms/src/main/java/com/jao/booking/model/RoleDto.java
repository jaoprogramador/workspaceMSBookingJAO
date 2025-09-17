package com.jao.booking.model;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class RoleDto {
    private UUID id;
    private String name;
    private String description;

    private Set<UUID> userIds; // solo los IDs de los usuarios
}
