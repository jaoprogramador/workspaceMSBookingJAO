package com.jao.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="GestHoteles-ms")
public interface GestHotelesCliente {
	 @RequestMapping("/api/hoteles/plazas-libres/{codigoHotel}")
	 boolean obtenerNumHabitacionesLibres(@PathVariable String codigoHotel);

}
