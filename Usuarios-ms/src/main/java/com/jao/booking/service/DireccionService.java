package com.jao.booking.service;

import com.jao.booking.model.DireccionDTO;
import java.util.List;

public interface DireccionService {
    List<DireccionDTO> findAll();
    DireccionDTO findById(Long id);
    DireccionDTO save(DireccionDTO dto);
    void delete(Long id);
}