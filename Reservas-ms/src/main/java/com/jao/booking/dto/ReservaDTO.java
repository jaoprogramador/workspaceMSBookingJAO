package com.jao.booking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import com.jao.booking.entity.ReservaEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ReservaDTO {
	
	private List <ReservaEntity> data;
	private int elementosTotales;
	private int paginasTotales;
	private int paginaActual;
	private boolean esPrimero;
	private boolean esUltimo;
	private boolean siguiente;
	private boolean anterior;
	
    private Long id;
    private Long usuarioId;
    private LocalDateTime fechaCreacion;
    private String estado;
    private BigDecimal total;
    private String vueloId;
    private String hotelId;
    private String vehiculoId;
    private String actividadId;
    private String pagoId;

    // Getters y setters o usa Lombok (@Data)
    public ReservaDTO (Page <ReservaEntity> reservaPagina) {
    	this.data = reservaPagina.getContent();
    	this.paginasTotales= (int) reservaPagina.getTotalElements();
    	this.paginasTotales= reservaPagina.getTotalPages();
    	this.paginaActual= reservaPagina.getNumber() + 1;
    	this.esPrimero = reservaPagina.isFirst();
    	this.esUltimo = reservaPagina.isLast();
    	this.siguiente = reservaPagina.hasNext();
    	this.anterior = reservaPagina.hasPrevious();
    	
    	
    }
}

