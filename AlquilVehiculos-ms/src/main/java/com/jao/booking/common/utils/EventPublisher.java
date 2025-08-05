package com.jao.booking.common.utils;

import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    // Aquí puedes conectar a Kafka, RabbitMQ o usar ApplicationEventPublisher

    public void publish(String topic, Object event) {
        // TODO: Implementar la lógica real
        System.out.println("Evento publicado: [" + topic + "] " + event.toString());
    }
}

