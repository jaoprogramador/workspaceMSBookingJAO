package com.jao.booking.service.notificacion.usuarios;

import com.jao.booking.model.UsuarioDTO;

public interface NotificacionUsuarioStrategy {
    void enviar(UsuarioDTO usuario);
}
