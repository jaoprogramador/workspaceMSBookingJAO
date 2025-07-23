package com.jao.booking.service.notificacion;

import com.jao.booking.model.ReservaNotificadaDTO;
import com.jao.booking.model.TipoNotificacion;
import com.jao.booking.service.email.MailService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificacionReserva implements NotificacionStrategy {
	private final MailService mailService = null;

    @Override
    public boolean acepta(TipoNotificacion tipo) {
        return tipo == TipoNotificacion.RESERVA;
    }

    
    
    @Override
    public void enviar(ReservaNotificadaDTO dto) {
    	log.info("📧 Enviando email de reserva para reserva ID: {}", dto.getReservaId());
        // lógica real de envío (emailService.send(...) por ejemplo)
    	String destinatario = "jaoprogramador@gmail.com"; // simulado
        String asunto = "Reserva Confirmada";
        String cuerpo = """
            <h1>¡Gracias por tu reserva!</h1>
            <p>ID Reserva: %d</p>
            <p>Total: €%s</p>
            <p>%s</p>
            """.formatted(dto.getReservaId(), dto.getTotal(), dto.getMensaje());

        mailService.enviarCorreo(destinatario, asunto, cuerpo);
    }
}

