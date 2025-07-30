package com.jao.booking.service;

import com.jao.booking.model.PreferenciaUsuarioDTO;
import java.util.List;

public interface PreferenciaUsuarioService {
    List<PreferenciaUsuarioDTO> findAll();
    PreferenciaUsuarioDTO findById(Long id);
    PreferenciaUsuarioDTO save(PreferenciaUsuarioDTO dto);
    void delete(Long id);
}