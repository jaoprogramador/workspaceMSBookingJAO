package com.jao.booking.service.impl;

import com.jao.booking.model.DatosBancariosDTO;
import com.jao.booking.common.exception.EntityNotFoundException;
import com.jao.booking.entity.DatosBancariosEntity;
//import com.jao.booking.exception.EntityNotFoundException;
import com.jao.booking.mapper.DatosBancariosMapper;
import com.jao.booking.repository.DatosBancariosRepository;
import com.jao.booking.service.DatosBancariosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatosBancariosServiceImpl implements DatosBancariosService {

    private final DatosBancariosRepository repository;
    private final DatosBancariosMapper mapper;

    public DatosBancariosServiceImpl(DatosBancariosRepository repository, DatosBancariosMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DatosBancariosDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public DatosBancariosDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("DatosBancarios", id));
    }

    @Override
    public DatosBancariosDTO save(DatosBancariosDTO dto) {
        DatosBancariosEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("DatosBancarios", id);
        }
        repository.deleteById(id);
    }
}
