package com.jao.booking.service.notificacion.usuarios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jao.booking.common.exception.NotFoundException;
import com.jao.booking.entity.EstadoNotificacion;
import com.jao.booking.entity.NotificacionEntity;
import com.jao.booking.model.TipoNotificacion;
import com.jao.booking.model.UsuarioDTO;
import com.jao.booking.repository.NotificacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionUsuarioService {

    private final NotificacionUsuarioStrategy strategy;
    private final NotificacionRepository repository;
    public void procesarNotificacion(UsuarioDTO usuario) {
        strategy.enviar(usuario);
    }
    public NotificacionEntity crearNotificacion(UsuarioDTO dto) {
        NotificacionEntity notificacion = NotificacionEntity.builder()
            .reservaId(null)
            .usuarioId(dto.getId())
            .total(null)
            .mensaje("Se ha creado el usuario "+dto.getApellido()+dto.getNombre())
            .destinatario("jaoprogramador@gmail.com")
            .tipo(TipoNotificacion.USUARIO)
            .estado(EstadoNotificacion.ENVIADA)
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
