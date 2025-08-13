package com.jao.booking.listener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.jao.booking.model.UsuarioDTO;
import com.jao.booking.service.notificacion.usuarios.NotificacionUsuarioService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UsuariosKFKConsumer {
    
    private final NotificacionUsuarioService notificacionUsuarioService;
    public UsuariosKFKConsumer(NotificacionUsuarioService notificacionUsuarioService) {
        
        this.notificacionUsuarioService = notificacionUsuarioService;
    }

 
    @KafkaListener(
        topics = "usuario-creado",
        groupId = "notificaciones-group",
        containerFactory = "usuarioKafkaListenerContainerFactory"
    )
    public void escuchar(UsuarioDTO usuario) {
    	log.info("Notificaciones-ms.NotificacionConsumer.escuchar:::INI-USUARIOS");
    	log.info("Notificaciones-ms.NotificacionConsumer.Usuario.:::"+usuario);
        System.out.println("Recibido: " + usuario.getNombre());
        notificacionUsuarioService.procesarNotificacion(usuario);
        
        //notificacionService.procesarNotificacion(usuario);
        log.info("GUARDAR EN BD la NOTIFICACION USUARIO CREADO");
        // Convertir DTO de evento a DTO interno de notificación
        
        
        notificacionUsuarioService.crearNotificacion(usuario);
        log.info("Notificaciones-ms.NotificacionConsumer.escuchar:::FIN-USUARIOS");
    }
}
