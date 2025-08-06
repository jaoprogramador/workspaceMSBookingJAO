package com.jao.booking.service.impl;

import org.springframework.stereotype.Service;

import com.jao.booking.common.exception.ResourceNotFoundException;
import com.jao.booking.entity.SucursalEntity;
import com.jao.booking.entity.VehiculoEntity;
import com.jao.booking.mapper.AlquilerVehiculosMapper;
import com.jao.booking.model.SucursalDTO;
import com.jao.booking.model.VehiculoDTO;
import com.jao.booking.repository.SucursalRepository;
import com.jao.booking.repository.VehiculoRepository;
import com.jao.booking.service.AlquilerVehiculosService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlquilerVehiculosServiceImpl implements AlquilerVehiculosService {

    private final VehiculoRepository vehiculoRepository;
    private final SucursalRepository sucursalRepository;

    public AlquilerVehiculosServiceImpl(VehiculoRepository vehiculoRepository, SucursalRepository sucursalRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.sucursalRepository = sucursalRepository;
    }

    // Vehículos
    @Override
    public Flux<VehiculoDTO> getAllVehiculos() {
        return vehiculoRepository.findAll()
                .map(AlquilerVehiculosMapper::toDto);
    }

    @Override
    public Mono<VehiculoDTO> getVehiculoById(Long id) {
        return vehiculoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Vehiculo no encontrado: " + id)))
                .map(AlquilerVehiculosMapper::toDto);
    }

    @Override
    public Mono<VehiculoDTO> saveVehiculo(VehiculoDTO dto) {
        VehiculoEntity vehiculo = AlquilerVehiculosMapper.toEntity(dto);
        return vehiculoRepository.save(vehiculo)
                .map(AlquilerVehiculosMapper::toDto);
    }

    @Override
    public Mono<Void> deleteVehiculo(Long id) {
        return vehiculoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Vehiculo no encontrado: " + id)))
                .flatMap(v -> vehiculoRepository.deleteById(id));
    }

    // Sucursales
    @Override
    public Flux<SucursalDTO> getAllSucursales() {
        return sucursalRepository.findAll()
                .map(AlquilerVehiculosMapper::toDto);
    }

    @Override
    public Mono<SucursalDTO> getSucursalById(Long id) {
        return sucursalRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Sucursal no encontrada: " + id)))
                .map(AlquilerVehiculosMapper::toDto);
    }

    @Override
    public Mono<SucursalDTO> saveSucursal(SucursalDTO dto) {
        SucursalEntity sucursal = AlquilerVehiculosMapper.toEntity(dto);
        return sucursalRepository.save(sucursal)
                .map(AlquilerVehiculosMapper::toDto);
    }

    @Override
    public Mono<Void> deleteSucursal(Long id) {
        return sucursalRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Sucursal no encontrada: " + id)))
                .flatMap(s -> sucursalRepository.deleteById(id));
    }
}
