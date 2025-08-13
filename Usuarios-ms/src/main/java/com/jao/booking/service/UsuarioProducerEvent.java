package com.jao.booking.service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.jao.booking.model.UsuarioDTO;

@Service
public class UsuarioProducerEvent {
	private final KafkaTemplate<String, UsuarioDTO> kafkaTemplate;

    public UsuarioProducerEvent(KafkaTemplate<String, UsuarioDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarUsuarioCreado(UsuarioDTO usuario) {
        kafkaTemplate.send("usuario-creado", usuario);
    }

}
