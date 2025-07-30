package com.jao.booking.service.impl;

import com.jao.booking.model.HabitacionDto;
import com.jao.booking.entity.HabitacionEntity;
import com.jao.booking.entity.HotelEntity;
import com.jao.booking.mapper.HabitacionMapper;
import com.jao.booking.repository.HabitacionRepository;
import com.jao.booking.repository.HotelRepository;
import com.jao.booking.service.HabitacionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements HabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final HotelRepository hotelRepository;

    @Override
    public List<HabitacionDto> obtenerTodas() {
        return habitacionRepository.findAll().stream()
                .map(HabitacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HabitacionDto obtenerPorId(Long id) {
        HabitacionEntity entity = habitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));
        return HabitacionMapper.toDto(entity);
    }

    @Override
    public HabitacionDto crear(HabitacionDto dto) {
        HotelEntity hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
        HabitacionEntity entity = HabitacionMapper.toEntity(dto, hotel);
        return HabitacionMapper.toDto(habitacionRepository.save(entity));
    }

    @Override
    public HabitacionDto actualizar(Long id, HabitacionDto dto) {
        HabitacionEntity existente = habitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        HotelEntity hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));

        HabitacionEntity actualizado = HabitacionMapper.toEntity(dto, hotel);
        actualizado.setIdHabitacion(id);

        return HabitacionMapper.toDto(habitacionRepository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        habitacionRepository.deleteById(id);
    }
}

