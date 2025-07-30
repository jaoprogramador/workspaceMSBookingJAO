package com.jao.booking.service;

import com.jao.booking.model.DatosBancariosDTO;
import java.util.List;

public interface DatosBancariosService {
    List<DatosBancariosDTO> findAll();
    DatosBancariosDTO findById(Long id);
    DatosBancariosDTO save(DatosBancariosDTO dto);
    void delete(Long id);
}
