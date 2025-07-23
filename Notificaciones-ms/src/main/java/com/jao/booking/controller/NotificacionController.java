package com.jao.booking.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jao.booking.entity.NotificacionEntity;
import com.jao.booking.model.ReservaNotificadaDTO;
import com.jao.booking.service.notificacion.NotificacionService;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService service;

    @PostMapping
    public ResponseEntity<NotificacionEntity> crear(@RequestBody ReservaNotificadaDTO dto) {
        return ResponseEntity.ok(service.crearNotificacion(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NotificacionEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}

