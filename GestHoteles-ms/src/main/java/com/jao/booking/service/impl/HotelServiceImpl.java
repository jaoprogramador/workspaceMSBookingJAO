package com.jao.booking.service.impl;

import com.jao.booking.model.HotelDto;
import com.jao.booking.entity.HotelEntity;
import com.jao.booking.mapper.HotelMapper;
import com.jao.booking.repository.HotelRepository;
import com.jao.booking.service.HotelService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public List<HotelDto> obtenerTodos() {
        return hotelRepository.findAll().stream()
                .map(HotelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HotelDto obtenerPorId(Long id) {
        return hotelRepository.findById(id)
                .map(HotelMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
    }

    @Override
    public HotelDto crear(HotelDto dto) {
        HotelEntity entity = HotelMapper.toEntity(dto);
        return HotelMapper.toDto(hotelRepository.save(entity));
    }

    @Override
    public HotelDto actualizar(Long id, HotelDto dto) {
        Optional<HotelEntity> optional = hotelRepository.findById(id);
        if (optional.isEmpty()) throw new RuntimeException("Hotel no encontrado");
        HotelEntity actualizado = HotelMapper.toEntity(dto);
        actualizado.setIdHotel(id);
        return HotelMapper.toDto(hotelRepository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        hotelRepository.deleteById(id);
    }
}
