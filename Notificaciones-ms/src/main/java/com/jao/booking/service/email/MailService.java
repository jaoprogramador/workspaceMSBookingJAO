package com.jao.booking.service.email;

public interface MailService {
	void enviarCorreo(String destinatario, String asunto, String cuerpo);

}
