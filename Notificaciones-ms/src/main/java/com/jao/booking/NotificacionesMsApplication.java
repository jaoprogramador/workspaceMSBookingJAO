package com.jao.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories(basePackages = "com.jao.booking.repository")
@EntityScan(basePackages = "com.jao.booking.entity")
public class NotificacionesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacionesMsApplication.class, args);
	}

}
