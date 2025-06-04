package com.jao.booking.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Document(value="vuelo")
@Getter
@Setter
@NoArgsConstructor

public class VueloEntity {
	@Id
	private String id;

    private String codigoVuelo;

    private String origen;

    private String destino;

    private LocalDateTime fechaSalida;

    private LocalDateTime fechaLlegada;

    private String aerolinea;

    private Double precio;

    private Integer capacidad;

    private Integer asientosDisponibles;
    
    private String estado;
}
