package com.jao.booking.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jao.booking.entity.VueloEntity;
import com.jao.booking.respository.VueloRepository;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    @Autowired
    private VueloRepository vueloRepository;

    // Obtener todos los vuelos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VueloEntity> obtenerTodosLosVuelos() {
        return vueloRepository.findAll();
    }

    // Obtener un vuelo por ID
    @GetMapping("/{id}")
    public ResponseEntity<VueloEntity> obtenerVueloPorId(@PathVariable String id) {
        Optional<VueloEntity> vuelo = vueloRepository.findById(id);
        return vuelo.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
 // Obtener un vuelo por codigoVuelo
    @GetMapping("/plazas-libres/{codigoVuelo}")
    public boolean obtenerNumPlazasLibres(@PathVariable String codigoVuelo) {
    	
    	// ⚠️ Simulación de error para probar Circuit Breaker
        //throw new RuntimeException("Error simulado en obtenerNumPlazasLibres");

        // Código real (se ignora mientras se prueba el fallback)
        
        Optional<VueloEntity> vueloOpt = vueloRepository.findByCodigoVuelo(codigoVuelo);

        if (vueloOpt.isEmpty()) {
            return false;
        }

        VueloEntity vuelo = vueloOpt.get();
        if (vuelo.getAsientosDisponibles() == null || vuelo.getAsientosDisponibles() <= 0) {
            return false;
        }

        return true;
        
    }


    // Crear un nuevo vuelo
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VueloEntity crearVuelo(@RequestBody VueloEntity vuelo) {
        return vueloRepository.save(vuelo);
    }

    // Actualizar un vuelo existente
    @PutMapping("/{id}")
    public ResponseEntity<VueloEntity> actualizarVuelo(@PathVariable String id, @RequestBody VueloEntity vueloActualizado) {
        Optional<VueloEntity> vueloExistente = vueloRepository.findById(id);
        if (vueloExistente.isPresent()) {
            vueloActualizado.setId(id); // Asegura que el ID no cambie
            return ResponseEntity.ok(vueloRepository.save(vueloActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un vuelo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable String id) {
        if (vueloRepository.existsById(id)) {
            vueloRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}