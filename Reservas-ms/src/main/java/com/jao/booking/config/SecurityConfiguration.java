package com.jao.booking.config;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	            	.requestMatchers("/metrics").permitAll()
	            	.requestMatchers("/actuator/prometheus").permitAll()
	                .requestMatchers("/actuator/**").permitAll()  // Permitir acceso sin autenticación a Actuator
	                .anyRequest().authenticated()                // El resto requiere autenticación
	            )
	            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	            //.oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Activa JWT si usas Keycloak

	        return http.build();
	    }
	    
}
/*
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt()
            );

        return http.build();
    }
}
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt()
            );

        return http.build();
    }*/



