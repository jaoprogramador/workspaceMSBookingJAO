package com.jao.booking.controller;

import com.jao.booking.model.HotelDto;
import com.jao.booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelDto>> obtenerTodos() {
        return ResponseEntity.ok(hotelService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<HotelDto> crear(@RequestBody HotelDto hotelDto) {
        return ResponseEntity.ok(hotelService.crear(hotelDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDto> actualizar(@PathVariable Long id, @RequestBody HotelDto hotelDto) {
        return ResponseEntity.ok(hotelService.actualizar(id, hotelDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        hotelService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/plazas-libres/{idHotel}")
    public ResponseEntity<Boolean> tienePlazasLibres(@PathVariable Long idHotel) {
        boolean disponible = hotelService.tieneHabitacionesDisponibles(idHotel);
        return ResponseEntity.ok(disponible);
    }
}
