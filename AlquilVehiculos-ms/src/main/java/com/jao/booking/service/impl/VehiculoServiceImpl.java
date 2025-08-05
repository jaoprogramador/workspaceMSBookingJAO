package com.jao.booking.service.impl;


import com.jao.booking.entity.VehiculoEntity;
import com.jao.booking.model.VehiculoDTO;
import com.jao.booking.mapper.VehiculoMapper;
import com.jao.booking.repository.SucursalRepository;
import com.jao.booking.repository.VehiculoRepository;
import com.jao.booking.service.VehiculoService;
import com.jao.booking.common.utils.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepo;
    private final SucursalRepository sucursalRepo;
    private final EventPublisher eventPublisher;

    @Override
    public Flux<VehiculoDTO> obtenerVehiculosDisponibles() {
        return vehiculoRepo.findByDisponibleTrue()
                .map(VehiculoMapper::toDto);
    }

    @Override
    public Mono<VehiculoDTO> crearVehiculo(VehiculoDTO dto) {
        return sucursalRepo.findById(dto.getSucursalId())
                .switchIfEmpty(Mono.error(new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Sucursal no encontrada")))
                .map(s -> VehiculoMapper.toEntity(dto, s))
                .flatMap(vehiculoRepo::save)
                .doOnSuccess(saved -> eventPublisher.publish("vehiculo.creado", saved))
                .map(VehiculoMapper::toDto);
    }

    @Override
    public Mono<VehiculoDTO> actualizarDisponibilidad(Long id, boolean disponible) {
        return vehiculoRepo.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Vehículo no encontrado")))
                .flatMap(v -> {
                    v.setDisponible(disponible);
                    return vehiculoRepo.save(v);
                })
                .doOnSuccess(updated -> eventPublisher.publish("vehiculo.actualizado", updated))
                .map(VehiculoMapper::toDto);
    }
    @Override
    public Flux<VehiculoDTO> obtenerVehiculosPaginados(int page, int size, Boolean disponible) {
        Flux<VehiculoEntity> vehiculosFlux = disponible == null
                ? vehiculoRepo.findAll()
                : vehiculoRepo.findByDisponible(disponible);

        
		return vehiculosFlux
                .skip((long) page * size)
                .take(size)
                .map(VehiculoMapper::toDto);
    }
	
}

