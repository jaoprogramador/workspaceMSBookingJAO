package com.jao.booking.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.jao.booking.config.RabbitMQConfig;
import com.jao.booking.model.ReservaNotificadaDTO;
import com.jao.booking.service.notificacion.NotificacionService;

@Slf4j
@Component
public class NotificacionListener {

	private final NotificacionService notificacionService;
	
	public NotificacionListener(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recibirNotificacion(ReservaNotificadaDTO dto) {
    	log.info("Notificaciones-ms.recibirNotificacion:::INI");
        log.info("📩 Notificación recibida:");
        log.info("Reserva ID: {}", dto.getReservaId());
        log.info("Usuario ID: {}", dto.getUsuarioId());
        log.info("Total: {}", dto.getTotal());
        log.info("Mensaje: {}", dto.getMensaje());
        log.info("Notificaciones-ms.recibirNotificacion:::FIN");
        // Aquí podrías enviar email, guardar en BD, o publicar evento
        log.info("MANDAR MAIL: {}", dto.getMensaje());
        notificacionService.procesarNotificacion(dto);
        log.info("GUARDAR EN BD la NOTIFICACION");
        // Convertir DTO de evento a DTO interno de notificación
        

        notificacionService.crearNotificacion(dto);

        log.info("📨 Notificación procesada y almacenada correctamente.");

    }
}

