package com.jao.booking.service.notificacion.reservas;

import com.jao.booking.model.ReservaNotificadaDTO;
import com.jao.booking.model.TipoNotificacion;
import com.jao.booking.model.UsuarioDTO;

public interface NotificacionStrategy {
	boolean acepta(TipoNotificacion tipo);
	
    void enviar(ReservaNotificadaDTO dto);
    
}
