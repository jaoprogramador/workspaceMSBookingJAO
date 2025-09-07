package com.jao.booking.config;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http .authorizeHttpRequests(auth -> auth
	 * .anyRequest().authenticated() ) .oauth2ResourceServer(oauth2 -> oauth2 .jwt()
	 * );
	 * 
	 * return http.build(); }
	 */
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
        		// Permitir Swagger/OpenAPI sin autenticación
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
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


