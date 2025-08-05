package com.jao.booking.service.impl;

import com.jao.booking.model.SucursalDTO;
import com.jao.booking.entity.SucursalEntity;
import com.jao.booking.mapper.SucursalMapper;
import com.jao.booking.repository.SucursalRepository;
import com.jao.booking.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepo;

    @Override
    public Mono<SucursalDTO> crearSucursal(SucursalDTO dto) {
        SucursalEntity entity = SucursalMapper.toEntity(dto);
        return sucursalRepo.save(entity)
                .map(SucursalMapper::toDto);
    }

    @Override
    public Flux<SucursalDTO> obtenerTodas() {
        return sucursalRepo.findAll()
                .map(SucursalMapper::toDto);
    }

    @Override
    public Mono<SucursalDTO> obtenerPorId(Long id) {
        return sucursalRepo.findById(id)
                .map(SucursalMapper::toDto);
    }

    @Override
    public Mono<SucursalDTO> actualizarSucursal(Long id, SucursalDTO dto) {
        return sucursalRepo.findById(id)
                .flatMap(existing -> {
                    existing.setNombre(dto.getNombre());
                    existing.setDireccion(dto.getDireccion());
                    existing.setCiudad(dto.getCiudad());
                    existing.setPais(dto.getPais());
                    return sucursalRepo.save(existing);
                })
                .map(SucursalMapper::toDto);
    }

    @Override
    public Mono<Void> eliminarSucursal(Long id) {
        return sucursalRepo.deleteById(id);
    }
}

