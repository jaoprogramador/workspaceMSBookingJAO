package com.jao.booking.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "reservaExchange";
    public static final String QUEUE = "reservaNotificacionQueue";
    public static final String ROUTING_KEY = "reserva.notificada";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    
    // 🔄 Conversor de mensajes a JSON (Jackson)
	
	@Bean public MessageConverter jsonMessageConverter() { 
		  return new Jackson2JsonMessageConverter(); 
	}
	  
	  // 🔄 Inyectamos RabbitTemplate usando el conversor
	  
  @Bean public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
	  RabbitTemplate template = new RabbitTemplate(connectionFactory);
	  template.setMessageConverter(jsonMessageConverter()); 
	  return template; 
  }
	 
}
