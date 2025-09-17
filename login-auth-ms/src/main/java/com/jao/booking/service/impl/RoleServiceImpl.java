package com.jao.booking.service.impl;

import com.jao.booking.model.RoleDto;
import com.jao.booking.entity.RoleEntity;
import com.jao.booking.mapper.RoleMapper;
import com.jao.booking.repository.RoleRepository;
import com.jao.booking.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        RoleEntity entity = roleMapper.toEntity(roleDto);
        RoleEntity saved = roleRepository.save(entity);
        return roleMapper.toDto(saved);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .toList();
    }

    @Override
    public RoleDto getRoleById(UUID id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    @Override
    public RoleDto getRoleByName(String name) {
        return roleRepository.findByName(name)
                .map(roleMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }
}

