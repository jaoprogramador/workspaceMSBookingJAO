package com.jao.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jao.booking.repository")
@EntityScan(basePackages = "com.jao.booking.entity")
public class LoginAuthMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAuthMsApplication.class, args);
	}

}
