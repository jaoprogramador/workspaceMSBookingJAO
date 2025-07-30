package com.jao.booking.service.impl;

import com.jao.booking.model.ImagenDto;
import com.jao.booking.entity.HabitacionEntity;
import com.jao.booking.entity.ImagenEntity;
import com.jao.booking.mapper.ImagenMapper;
import com.jao.booking.repository.HabitacionRepository;
import com.jao.booking.repository.ImagenRepository;
import com.jao.booking.service.ImagenService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImagenServiceImpl implements ImagenService {

    private final ImagenRepository imagenRepository;
    private final HabitacionRepository habitacionRepository;

    @Override
    public List<ImagenDto> obtenerTodas() {
        return imagenRepository.findAll().stream()
                .map(ImagenMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ImagenDto obtenerPorId(Long id) {
        return imagenRepository.findById(id)
                .map(ImagenMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
    }

    @Override
    public ImagenDto crear(ImagenDto dto) {
        HabitacionEntity habitacion = habitacionRepository.findById(dto.getHabitacionId())
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));
        ImagenEntity entity = ImagenMapper.toEntity(dto, habitacion);
        return ImagenMapper.toDto(imagenRepository.save(entity));
    }

    @Override
    public ImagenDto actualizar(Long id, ImagenDto dto) {
        ImagenEntity existente = imagenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));

        HabitacionEntity habitacion = habitacionRepository.findById(dto.getHabitacionId())
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));

        ImagenEntity actualizado = ImagenMapper.toEntity(dto, habitacion);
        actualizado.setIdImagen(id);

        return ImagenMapper.toDto(imagenRepository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        imagenRepository.deleteById(id);
    }
}

