package com.jao.booking.service;
import java.util.List;

import com.jao.booking.model.ImagenDto;

public interface ImagenService {
    List<ImagenDto> obtenerTodas();
    ImagenDto obtenerPorId(Long id);
    ImagenDto crear(ImagenDto dto);
    ImagenDto actualizar(Long id, ImagenDto dto);
    void eliminar(Long id);
}

