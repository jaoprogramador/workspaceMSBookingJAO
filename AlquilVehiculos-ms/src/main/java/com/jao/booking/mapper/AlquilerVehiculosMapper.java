package com.jao.booking.mapper;

import com.jao.booking.entity.SucursalEntity;
import com.jao.booking.entity.VehiculoEntity;
import com.jao.booking.model.SucursalDTO;
import com.jao.booking.model.VehiculoDTO;

public class AlquilerVehiculosMapper {
    public static VehiculoDTO toDto(VehiculoEntity v) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(v.getId());
        dto.setMarca(v.getMarca());
        dto.setModelo(v.getModelo());
        dto.setAño(v.getAño());
        dto.setSucursalId(v.getSucursalId());
        dto.setDisponible(v.isDisponible());
        return dto;
    }

    public static VehiculoEntity toEntity(VehiculoDTO dto) {
    	VehiculoEntity v = new VehiculoEntity();
        v.setId(dto.getId());
        v.setMarca(dto.getMarca());
        v.setModelo(dto.getModelo());
        v.setAño(dto.getAño());
        v.setSucursalId(dto.getSucursalId());
        v.setDisponible(dto.isDisponible());
        return v;
    }

    public static SucursalDTO toDto(SucursalEntity s) {
        SucursalDTO dto = new SucursalDTO();
        dto.setId(s.getId());
        dto.setNombre(s.getNombre());
        dto.setDireccion(s.getDireccion());
        dto.setCiudad(s.getCiudad());
        return dto;
    }

    public static SucursalEntity toEntity(SucursalDTO dto) {
    	SucursalEntity s = new SucursalEntity();
        s.setId(dto.getId());
        s.setNombre(dto.getNombre());
        s.setDireccion(dto.getDireccion());
        s.setCiudad(dto.getCiudad());
        return s;
    }
}

