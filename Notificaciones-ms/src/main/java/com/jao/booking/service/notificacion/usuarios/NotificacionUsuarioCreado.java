package com.jao.booking.service.notificacion.usuarios;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.jao.booking.model.UsuarioDTO;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificacionUsuarioCreado implements NotificacionUsuarioStrategy {

    private final JavaMailSender mailSender;
    

    @Override
    public void enviar(UsuarioDTO usuario) {
        log.info("📨 Enviando notificación por nuevo usuario creado: {}", usuario.getEmail());

        // Enviar email
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo("admin@miapp.com"); // o usuario.getEmail() si corresponde
        mensaje.setSubject("🆕 Nuevo usuario creado");
        mensaje.setText("Nombre: " + usuario.getNombre() + " " + usuario.getApellido() +
                        "\nEmail: " + usuario.getEmail());

        mailSender.send(mensaje);

        

        log.info("✅ Notificación de usuario registrada en la base de datos.");
    }
}