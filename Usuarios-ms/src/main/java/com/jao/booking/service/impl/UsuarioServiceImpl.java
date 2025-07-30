package com.jao.booking.service.impl;

import com.jao.booking.model.UsuarioDTO;
import com.jao.booking.common.exception.EntityNotFoundException;
import com.jao.booking.entity.UsuarioEntity;

import com.jao.booking.mapper.UsuarioMapper;
import com.jao.booking.repository.UsuarioRepository;
import com.jao.booking.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public UsuarioDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Usuario", id));
    }

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        UsuarioEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuario", id);
        }
        repository.deleteById(id);
    }
}
