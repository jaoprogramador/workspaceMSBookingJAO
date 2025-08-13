package com.jao.booking.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.jao.booking.model.UsuarioDTO;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, UsuarioDTO> usuarioConsumerFactory() {
        JsonDeserializer<UsuarioDTO> deserializer = new JsonDeserializer<>(UsuarioDTO.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("com.jao.booking.model");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Cambia si usas otro host
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "notificaciones-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UsuarioDTO> usuarioKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UsuarioDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(usuarioConsumerFactory());
        return factory;
    }
}
