package com.jao.booking.mapper;

import com.jao.booking.model.RoleDto;
import com.jao.booking.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleDto toDto(RoleEntity entity);
    RoleEntity toEntity(RoleDto dto);

}

