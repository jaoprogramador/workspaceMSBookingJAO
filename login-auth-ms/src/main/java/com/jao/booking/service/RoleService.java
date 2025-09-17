package com.jao.booking.service;

import com.jao.booking.model.RoleDto;
import java.util.List;
import java.util.UUID;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    List<RoleDto> getAllRoles();
    RoleDto getRoleById(UUID id);
    RoleDto getRoleByName(String name);
}

