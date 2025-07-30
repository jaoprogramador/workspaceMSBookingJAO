package com.jao.booking.service.impl;

import com.jao.booking.model.ResenaDto;
import com.jao.booking.entity.HotelEntity;
import com.jao.booking.entity.ResenaEntity;
import com.jao.booking.mapper.ResenaMapper;
import com.jao.booking.repository.HotelRepository;
import com.jao.booking.repository.ResenaRepository;
import com.jao.booking.service.ResenaService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResenaServiceImpl implements ResenaService {

    private final ResenaRepository resenaRepository;
    private final HotelRepository hotelRepository;

    @Override
    public List<ResenaDto> obtenerTodas() {
        return resenaRepository.findAll().stream()
                .map(ResenaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResenaDto obtenerPorId(Long id) {
        ResenaEntity entity = resenaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
        return ResenaMapper.toDto(entity);
    }

    @Override
    public ResenaDto crear(ResenaDto dto) {
        HotelEntity hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
        dto.setFecha(LocalDateTime.now());
        ResenaEntity entity = ResenaMapper.toEntity(dto, hotel);
        return ResenaMapper.toDto(resenaRepository.save(entity));
    }

    @Override
    public ResenaDto actualizar(Long id, ResenaDto dto) {
        ResenaEntity existente = resenaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
        HotelEntity hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
        dto.setFecha(existente.getFecha()); // preserva la fecha original
        ResenaEntity actualizado = ResenaMapper.toEntity(dto, hotel);
        actualizado.setIdResena(id);
        return ResenaMapper.toDto(resenaRepository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        resenaRepository.deleteById(id);
    }
}

