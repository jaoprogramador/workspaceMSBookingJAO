package com.jao.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories(basePackages = "com.jao.booking.repository")
@EntityScan(basePackages = "com.jao.booking.entity")
//@EnableCircuitBreaker
//@EnableCircuitBreaker

public class ReservasMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasMsApplication.class, args);
	}

}
