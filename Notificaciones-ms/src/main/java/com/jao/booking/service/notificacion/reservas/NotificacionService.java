package com.jao.booking.service.notificacion.reservas;

import com.jao.booking.common.exception.NotFoundException;
import com.jao.booking.entity.EstadoNotificacion;
import com.jao.booking.entity.NotificacionEntity;
import com.jao.booking.model.ReservaNotificadaDTO;
import com.jao.booking.repository.NotificacionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final List<NotificacionStrategy> estrategias;
    private final NotificacionRepository repository;

    public void procesarNotificacion(ReservaNotificadaDTO dto) {
        estrategias.stream()
            .filter(e -> e.acepta(dto.getTipo()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Tipo de notificación no soportado: " + dto.getTipo()))
            .enviar(dto);
    }
    
    
    public NotificacionEntity crearNotificacion(ReservaNotificadaDTO dto) {
        NotificacionEntity notificacion = NotificacionEntity.builder()
            .reservaId(dto.getReservaId())
            .usuarioId(dto.getUsuarioId())
            .total(dto.getTotal())
            .mensaje(dto.getMensaje())
            .destinatario("jaoprogramador@gmail.com")
            .tipo(dto.getTipo())
            .estado(EstadoNotificacion.PENDIENTE)
            .fechaCreacion(LocalDateTime.now())
            .build();

        return repository.save(notificacion);
    }

    
    public NotificacionEntity getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Notificación no encontrada con ID: " + id));
    }

   
    public List<NotificacionEntity> getAll() {
        return repository.findAll();
    }
    
    
}
