package com.jao.booking.service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    @Override
    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        try {
            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);

            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpo, true); // true si es HTML

            mailSender.send(mensaje);
            log.info("📤 Correo enviado a {}", destinatario);
        } catch (MessagingException e) {
            log.error("❌ Error enviando correo: {}", e.getMessage(), e);
            throw new RuntimeException("Error al enviar correo", e);
        }
    }
}

