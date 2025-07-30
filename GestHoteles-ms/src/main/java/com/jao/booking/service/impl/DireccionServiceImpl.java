package com.jao.booking.service.impl;

import com.jao.booking.model.DireccionDto;
import com.jao.booking.entity.DireccionEntity;
import com.jao.booking.mapper.DireccionMapper;
import com.jao.booking.repository.DireccionRepository;
import com.jao.booking.service.DireccionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    @Override
    public List<DireccionDto> obtenerTodos() {
        return direccionRepository.findAll().stream()
                .map(DireccionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DireccionDto obtenerPorId(Long id) {
        return direccionRepository.findById(id)
                .map(DireccionMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
    }

    @Override
    public DireccionDto crear(DireccionDto dto) {
        DireccionEntity entity = DireccionMapper.toEntity(dto);
        return DireccionMapper.toDto(direccionRepository.save(entity));
    }

    @Override
    public DireccionDto actualizar(Long id, DireccionDto dto) {
        Optional<DireccionEntity> optional = direccionRepository.findById(id);
        if (optional.isEmpty()) throw new RuntimeException("Dirección no encontrada");
        DireccionEntity actualizado = DireccionMapper.toEntity(dto);
        actualizado.setIdDireccion(id);
        return DireccionMapper.toDto(direccionRepository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        direccionRepository.deleteById(id);
    }
}

