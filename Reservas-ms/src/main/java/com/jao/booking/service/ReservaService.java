package com.jao.booking.service;

import com.jao.booking.client.GestVuelosClient;
import com.jao.booking.common.exception.ReservaInvalidaException;
import com.jao.booking.common.exception.ReservaNotFoundException;
import com.jao.booking.config.RabbitMQConfig;
import com.jao.booking.dto.OrderDTO;
import com.jao.booking.dto.ReservaNotificadaDTO;
import com.jao.booking.dto.TipoNotificacion;
import com.jao.booking.entity.EstadoOrden;
import com.jao.booking.entity.OrderEntity;
import com.jao.booking.entity.OrderItemEntity;
import com.jao.booking.entity.ReservaEntity;
import com.jao.booking.repository.OrderRepository;
import com.jao.booking.repository.ReservaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservaService {

    private final GestVuelosClient vuelosClient;
    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;
    private final ReservaRepository reservaRepository;


    public String crearPedido(OrderDTO orderDTO, String codigoVuelo) {

        log.info("ReservaService:::crearPedido:::INI");

        boolean hayPlazas = vuelosClient.obtenerNumPlazasLibres(codigoVuelo);

        if (hayPlazas) {
            OrderEntity order = new OrderEntity();
            order.setOrderCode(UUID.randomUUID().toString());
            order.setFechaCreacion(LocalDateTime.now());
            order.setEstado(EstadoOrden.CREADA);

            BigDecimal total = orderDTO.getOrderItems().stream()
                    .map(OrderItemEntity::getPrecio)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            order.setMontoTotal(total);

            for (OrderItemEntity item : orderDTO.getOrderItems()) {
                item.setOrden(order);
            }
            order.setItems(orderDTO.getOrderItems());

            orderRepository.save(order);

            ReservaNotificadaDTO mensaje = new ReservaNotificadaDTO();
            mensaje.setReservaId(order.getId());
            mensaje.setUsuarioId(new Long(11111110)); // completar si tienes el usuario
            mensaje.setTotal(order.getMontoTotal());
            mensaje.setTipo(TipoNotificacion.VUELO);
            mensaje.setMensaje("Reserva creada exitosamente");

            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.EXCHANGE,
                    RabbitMQConfig.ROUTING_KEY,
                    mensaje
            );

            log.info("ReservaService:::crearPedido:::FIN");
            return "Petición CREADA";
        }

        log.info("ReservaService:::crearPedido:::FIN - No hay plazas");
        return "Petición NO CREADA. No hay plazas disponibles";
    }

    public String fallbackPedido(OrderDTO orderDTO, String codigoVuelo, Throwable throwable) {
        log.warn("ReservaService:::fallbackPedido:::Error: {}", throwable.getMessage());
        return "Algo va mal en el sistema, inténtelo de nuevo más tarde";
    }
    
    public List<ReservaEntity> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<ReservaEntity> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    public ReservaEntity getReservaByCode(Long code) {
    	ReservaEntity reserva = reservaRepository.findById(code)
                .orElseThrow(() -> new ReservaNotFoundException("No se encontró la reserva con código: " + code));

        if (reserva.getTotal() == null || reserva.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ReservaInvalidaException("La reserva tiene un total inválido (<= 0)");
        }
        return reserva;

    }

    public List<ReservaEntity> getReservasByUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    public ReservaEntity crearReserva(ReservaEntity reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<ReservaEntity> actualizarReserva(Long id, ReservaEntity reservaActualizada) {
        return reservaRepository.findById(id).map(reservaExistente -> {
            reservaActualizada.setId(id);
            return reservaRepository.save(reservaActualizada);
        });
    }

    public boolean eliminarReserva(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

