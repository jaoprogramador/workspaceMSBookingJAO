package com.jao.booking.service.notificacion;

import com.jao.booking.model.ReservaNotificadaDTO;
import com.jao.booking.model.TipoNotificacion;

public interface NotificacionStrategy {
	boolean acepta(TipoNotificacion tipo);
    void enviar(ReservaNotificadaDTO dto);

}
