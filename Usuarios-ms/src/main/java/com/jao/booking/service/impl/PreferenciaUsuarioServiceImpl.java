package com.jao.booking.service.impl;

import com.jao.booking.model.PreferenciaUsuarioDTO;
import com.jao.booking.entity.PreferenciaUsuarioEntity;
//import com.jao.booking.exception.EntityNotFoundException;
import com.jao.booking.common.exception.EntityNotFoundException;
import com.jao.booking.mapper.PreferenciaUsuarioMapper;
import com.jao.booking.repository.PreferenciaUsuarioRepository;
import com.jao.booking.service.PreferenciaUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenciaUsuarioServiceImpl implements PreferenciaUsuarioService {

    private final PreferenciaUsuarioRepository repository;
    private final PreferenciaUsuarioMapper mapper;

    public PreferenciaUsuarioServiceImpl(PreferenciaUsuarioRepository repository, PreferenciaUsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PreferenciaUsuarioDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public PreferenciaUsuarioDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("PreferenciaUsuario", id));
    }

    @Override
    public PreferenciaUsuarioDTO save(PreferenciaUsuarioDTO dto) {
        PreferenciaUsuarioEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("PreferenciaUsuario", id);
        }
        repository.deleteById(id);
    }
}
