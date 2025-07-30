package com.jao.booking.service.impl;

import com.jao.booking.model.DireccionDTO;
import com.jao.booking.common.exception.EntityNotFoundException;
import com.jao.booking.entity.DireccionEntity;
//import com.jao.booking.exception.EntityNotFoundException;
import com.jao.booking.mapper.DireccionMapper;
import com.jao.booking.repository.DireccionRepository;
import com.jao.booking.service.DireccionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository repository;
    private final DireccionMapper mapper;

    public DireccionServiceImpl(DireccionRepository repository, DireccionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DireccionDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public DireccionDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Direccion", id));
    }

    @Override
    public DireccionDTO save(DireccionDTO dto) {
        DireccionEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Direccion", id);
        }
        repository.deleteById(id);
    }
}