package com.jao.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="GestVuelos-ms")
public interface GestVuelosClient {
	 @RequestMapping("/api/vuelos/plazas-libres/{codigoVuelo}")
	 boolean obtenerNumPlazasLibres(@PathVariable String codigoVuelo);
}
