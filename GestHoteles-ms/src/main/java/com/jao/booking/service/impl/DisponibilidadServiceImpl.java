package com.jao.booking.service.impl;

import com.jao.booking.model.DisponibilidadDto;
import com.jao.booking.entity.DisponibilidadEntity;
import com.jao.booking.entity.HabitacionEntity;
import com.jao.booking.mapper.DisponibilidadMapper;
import com.jao.booking.repository.DisponibilidadRepository;
import com.jao.booking.repository.HabitacionRepository;
import com.jao.booking.service.DisponibilidadService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisponibilidadServiceImpl implements DisponibilidadService {

    private final DisponibilidadRepository disponibilidadRepository;
    private final HabitacionRepository habitacionRepository;

    @Override
    public List<DisponibilidadDto> obtenerTodas() {
        return disponibilidadRepository.findAll().stream()
                .map(DisponibilidadMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DisponibilidadDto obtenerPorId(Long id) {
        return disponibilidadRepository.findById(id)
                .map(DisponibilidadMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));
    }

    @Override
    public DisponibilidadDto crear(DisponibilidadDto dto) {
        HabitacionEntity habitacion = habitacionRepository.findById(dto.getHabitacionId())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));
        DisponibilidadEntity entity = DisponibilidadMapper.toEntity(dto, habitacion);
        return DisponibilidadMapper.toDto(disponibilidadRepository.save(entity));
    }

    @Override
    public DisponibilidadDto actualizar(Long id, DisponibilidadDto dto) {
        DisponibilidadEntity existente = disponibilidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));

        HabitacionEntity habitacion = habitacionRepository.findById(dto.getHabitacionId())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        DisponibilidadEntity actualizado = DisponibilidadMapper.toEntity(dto, habitacion);
        actualizado.setId(id);

        return DisponibilidadMapper.toDto(disponibilidadRepository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        disponibilidadRepository.deleteById(id);
    }
}
