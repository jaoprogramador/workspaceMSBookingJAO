package com.jao.booking.service;

import com.jao.booking.model.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> findAll();
    UsuarioDTO findById(Long id);
    UsuarioDTO save(UsuarioDTO dto);
    void delete(Long id);
}
