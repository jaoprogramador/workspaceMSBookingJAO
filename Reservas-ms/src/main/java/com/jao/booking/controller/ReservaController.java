package com.jao.booking.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jao.booking.entity.OrderItemEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jao.booking.client.GestVuelosClient;
import com.jao.booking.config.RabbitMQConfig;
import com.jao.booking.dto.OrderDTO;
import com.jao.booking.dto.ReservaNotificadaDTO;
import com.jao.booking.entity.EstadoOrden;
import com.jao.booking.entity.OrderEntity;
import com.jao.booking.entity.ReservaEntity;
import com.jao.booking.repository.OrderRepository;
import com.jao.booking.repository.ReservaRepository;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.jao.booking.service.ReservaService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
	private static final String CIRCUIT_BREAKER_NAME = "gestVuelosService";
	/*  

	
	@Autowired
    private final ReservaRepository reservaRepository;
	
	@Autowired
    private final OrderRepository orderRepository;
	
	@Autowired
	private GestVuelosClient vuelosClient;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping("/order")
	@CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackToGestVuelosService")
	
	public String crearPedido(@RequestBody OrderDTO orderDTO, @RequestParam String codigoVuelo) {

	    log.info("Reservas-ms:::crearPedido:::INI");

	    boolean hayPlazas = vuelosClient.obtenerNumPlazasLibres( codigoVuelo);
	    log.info("Reservas-ms:::crearPedido:::---El vuelo "+codigoVuelo+ "dispone de "+hayPlazas+" plazas libres");
		if(hayPlazas){
			OrderEntity order = new OrderEntity();
	        order.setOrderCode(UUID.randomUUID().toString());
	        order.setFechaCreacion(LocalDateTime.now());
	        order.setEstado(EstadoOrden.CREADA);

	        // Calcular monto total sumando los precios
	        BigDecimal total = orderDTO.getOrderItems().stream()
	            .map(OrderItemEntity::getPrecio)
	            .reduce(BigDecimal.ZERO, BigDecimal::add);
	        order.setMontoTotal(total);

	        // Setear ítems y bidirección
	        for (OrderItemEntity item : orderDTO.getOrderItems()) {
	            item.setOrden(order);
	        }
	        order.setItems(orderDTO.getOrderItems());

	        orderRepository.save(order);

	        // Enviar notificación a RabbitMQ
	        ReservaNotificadaDTO mensaje = new ReservaNotificadaDTO();
	        mensaje.setReservaId(order.getId());
	        mensaje.setUsuarioId(null); // no disponible en DTO
	        mensaje.setTotal(order.getMontoTotal());
	        mensaje.setMensaje("Reserva creada exitosamente");

	        rabbitTemplate.convertAndSend(
	            RabbitMQConfig.EXCHANGE,
	            RabbitMQConfig.ROUTING_KEY,
	            mensaje
	        );
	        //TODO Consultar el numero de vuelos y actualizarlo a total-1
	        // HAcer el MS GestActividades y centralizar desde aquí el pedido



			log.info("Reservas-ms:::crearPedido:::FIN");
			return "Petición CREADA";
		}
		log.info("Reservas-ms:::crearPedido:::FIN");
		return "Petición NO CREADA. No hay plazas disponibles";
	}

	public String fallbackToGestVuelosService(OrderDTO orderDTO, String codigoVuelo, Throwable throwable) {
		log.warn("Reservas-ms:::fallbackToGestVuelosService:::El vuelo solicitado no responde: {}", codigoVuelo);
		log.warn("Reservas-ms:::fallbackToGestVuelosService:::Error: {}", throwable.getMessage());
		log.warn("Reservas-ms:::fallbackToGestVuelosService:::Algo va mal en el sistema , intentelo de nuevo más tarde");
		return "Algo va mal en el sistema, inténtelo de nuevo más tarde";
	}
	
	
	
    // Obtener todas las reservas
    @GetMapping
    public List<ReservaEntity> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Obtener reserva por ID (numérico)
    @GetMapping("/{id}")
    public ResponseEntity<ReservaEntity> getReservaById(@PathVariable Long id) {
        return reservaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener reserva por "code" (string único)
    @GetMapping("/code/{code}")
    public ResponseEntity<ReservaEntity> getReservaByCode(@PathVariable Long code) {
    	Optional<ReservaEntity> reserva = reservaRepository.findById(code);

        ReservaEntity entity = reserva.orElseThrow(() -> 
            new RuntimeException("No se encontró la reserva con código: " + code)
        );

        if (entity.getTotal() == null || entity.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("La reserva tiene un total inválido (<= 0)");
        }

        return ResponseEntity.ok(entity);
    
    }

    // Obtener todas las reservas de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<ReservaEntity> getReservasByUsuario(@PathVariable Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    // Crear nueva reserva
    @PostMapping
    public ResponseEntity<ReservaEntity> crearReserva(@RequestBody ReservaEntity reserva) {
        ReservaEntity nuevaReserva = reservaRepository.save(reserva);
        return ResponseEntity.ok(nuevaReserva);
    }

    // Actualizar reserva
    @PutMapping("/{id}")
    public ResponseEntity<ReservaEntity> actualizarReserva(
            @PathVariable Long id,
            @RequestBody ReservaEntity reservaActualizada
    ) {
        return reservaRepository.findById(id).map(reservaExistente -> {
            reservaActualizada.setId(id); // mantener el ID original
            ReservaEntity actualizada = reservaRepository.save(reservaActualizada);
            return ResponseEntity.ok(actualizada);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
*/
	@Autowired
	private final ReservaService reservaService;
	@PostMapping("/order")
	@CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackToGestVuelosService")
	public String crearPedido(@RequestBody OrderDTO orderDTO, @RequestParam String codigoVuelo) {
		log.info("Reservas-ms:::ReservaController.crearPedido:::INI");
	    return reservaService.crearPedido(orderDTO, codigoVuelo);
	}

	public String fallbackToGestVuelosService(OrderDTO orderDTO, String codigoVuelo, Throwable throwable) {
		log.info("Reservas-ms:::ReservaController.fallbackToGestVuelosService:::INI");
	    return reservaService.fallbackPedido(orderDTO, codigoVuelo, throwable);
	}
	@GetMapping
	public List<ReservaEntity> getAllReservas() {
		log.info("Reservas-ms:::ReservaController.getAllReservas:::INI");
	    return reservaService.getAllReservas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReservaEntity> getReservaById(@PathVariable Long id) {
		log.info("Reservas-ms:::ReservaController.getReservaById:::INI");
	    return reservaService.getReservaById(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/code/{code}")
	public ResponseEntity<ReservaEntity> getReservaByCode(@PathVariable Long code) {
		log.info("Reservas-ms:::ReservaController.getReservaByCode:::INI");
		return ResponseEntity.ok(reservaService.getReservaByCode(code));


	}

	@GetMapping("/usuario/{usuarioId}")
	public List<ReservaEntity> getReservasByUsuario(@PathVariable Long usuarioId) {
		log.info("Reservas-ms:::ReservaController.getReservasByUsuario:::INI");
	    return reservaService.getReservasByUsuario(usuarioId);
	}

	@PostMapping
	public ResponseEntity<ReservaEntity> crearReserva(@RequestBody ReservaEntity reserva) {
		log.info("Reservas-ms:::ReservaController.crearReserva:::INI");
	    return ResponseEntity.ok(reservaService.crearReserva(reserva));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReservaEntity> actualizarReserva(
	        @PathVariable Long id,
	        @RequestBody ReservaEntity reservaActualizada
	) {
		log.info("Reservas-ms:::ReservaController.actualizarReserva:::INI");
	    return reservaService.actualizarReserva(id, reservaActualizada)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
		log.info("Reservas-ms:::ReservaController.eliminarReserva:::INI");
	    boolean eliminada = reservaService.eliminarReserva(id);
	    return eliminada ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
