package com.jao.booking.mapper;


import com.jao.booking.model.UserDto;
import com.jao.booking.entity.RoleEntity;
import com.jao.booking.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // ✅ De Entity a DTO → convertir RoleEntity → String
    @Mapping(target = "roles", expression = "java(mapRolesToStrings(entity.getRoles()))")
    UserDto toDto(UserEntity entity);

    // ✅ De DTO a Entity → convertir String → RoleEntity
    @Mapping(target = "roles", expression = "java(mapStringsToRoles(dto.getRoles()))")
    @Mapping(target = "passwordHash", ignore = true)   // se gestiona en servicio
    @Mapping(target = "salt", ignore = true)           // idem
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserEntity toEntity(UserDto dto);

    // 🔹 Helpers
    default Set<String> mapRolesToStrings(Set<RoleEntity> roles) {
        if (roles == null) return Collections.emptySet();
        return roles.stream()
                .map(RoleEntity::getName)
                .collect(Collectors.toSet());
    }

    default Set<RoleEntity> mapStringsToRoles(Set<String> roles) {
        if (roles == null) return Collections.emptySet();
        return roles.stream()
                .map(name -> {
                    RoleEntity role = new RoleEntity();
                    role.setName(name);
                    return role;
                })
                .collect(Collectors.toSet());
    }
}

