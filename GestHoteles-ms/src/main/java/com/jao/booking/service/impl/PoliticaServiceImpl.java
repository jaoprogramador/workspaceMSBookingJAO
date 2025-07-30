package com.jao.booking.service.impl;

import com.jao.booking.model.PoliticaDto;
import com.jao.booking.entity.HotelEntity;
import com.jao.booking.entity.PoliticaEntity;
import com.jao.booking.mapper.PoliticaMapper;
import com.jao.booking.repository.HotelRepository;
import com.jao.booking.repository.PoliticaRepository;
import com.jao.booking.service.PoliticaService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PoliticaServiceImpl implements PoliticaService {

    private final PoliticaRepository politicaRepository;
    private final HotelRepository hotelRepository;

    @Override
    public List<PoliticaDto> obtenerTodas() {
        return politicaRepository.findAll().stream()
                .map(PoliticaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PoliticaDto obtenerPorId(Long id) {
        PoliticaEntity entity = politicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Política no encontrada"));
        return PoliticaMapper.toDto(entity);
    }

    @Override
    public PoliticaDto crear(PoliticaDto dto) {
        HotelEntity hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
        PoliticaEntity entity = PoliticaMapper.toEntity(dto, hotel);
        return PoliticaMapper.toDto(politicaRepository.save(entity));
    }

    @Override
    public PoliticaDto actualizar(Long id, PoliticaDto dto) {
        PoliticaEntity existente = politicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Política no encontrada"));
        HotelEntity hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
        PoliticaEntity actualizado = PoliticaMapper.toEntity(dto, hotel);
        actualizado.setIdPolitica(id);
        return PoliticaMapper.toDto(politicaRepository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        politicaRepository.deleteById(id);
    }
}
