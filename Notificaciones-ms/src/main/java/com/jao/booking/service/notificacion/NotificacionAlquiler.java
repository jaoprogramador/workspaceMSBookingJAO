package com.jao.booking.service.notificacion;

import com.jao.booking.model.ReservaNotificadaDTO;
import com.jao.booking.model.TipoNotificacion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificacionAlquiler implements NotificacionStrategy {

    @Override
    public boolean acepta(TipoNotificacion tipo) {
        return tipo == TipoNotificacion.ALQUILER;
    }

    @Override
    public void enviar(ReservaNotificadaDTO dto) {
        log.info("📧 Enviando email de reserva para reserva ID: {}", dto.getReservaId());
        // lógica real de envío (emailService.send(...) por ejemplo)
    }
}
