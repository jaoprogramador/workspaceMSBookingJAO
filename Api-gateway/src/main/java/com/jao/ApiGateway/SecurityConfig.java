package com.jao.ApiGateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
	    http
	        .authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
	        .oauth2ResourceServer(oauth2 -> oauth2.jwt());
	    http.csrf().disable();
	    return http.build();
	}
	
	//En tu API Gateway ahora mismo estás usando únicamente el flujo de oauth2Login, 
	//que es el que arranca el proceso de “login por navegador” (y por eso te devuelve el HTML de Keycloak). 
	//Lo que en realidad necesitas es que el Gateway valide el Bearer‑JWT que le envías y se comporte como un Resource Server, 
	//no como un cliente de login.

	//oauth2Login() es para aplicaciones con login vía navegador (authorization code flow con UI
	 /*@Bean
    public SecurityWebFilterChain SecurityWebFilterChain(ServerHttpSecurity httpSecurity) {
		httpSecurity.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
                .oauth2Login(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        
        return httpSecurity.build();
    }
    	 
    */
    	 /*
	 @Bean
	 public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
	        http
	          // Deshabilita CSRF si es solo API stateless
	          .csrf().disable()
	          // Todas las peticiones a /api/** requieren autenticación
	          .authorizeExchange(exchanges -> exchanges
	              .pathMatchers("/api/**").authenticated()
	              .anyExchange().permitAll()
	          )
	          // Aquí es donde validas el JWT en el header Authorization
	          .oauth2ResourceServer(oauth2 -> oauth2
	              .jwt()
	          );

	        return http.build();
	    }*/
	
	/*
	 * @Bean public SecurityWebFilterChain ecurityWebFilterChain(ServerHttpSecurity
	 * httpSecurity) { httpSecurity.authorizeExchange(exchanges ->
	 * exchanges.anyExchange().authenticated())
	 * .oauth2Login(Customizer.withDefaults()); httpSecurity.csrf().disable();
	 * 
	 * return httpSecurity.build(); }
	 */
	 
	/*
	 * @Bean public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity
	 * http) { System.out.println("JAO:::SecurityConfig:::ini"); return http
	 * .authorizeExchange(exchanges -> exchanges .anyExchange().authenticated() )
	 * .oauth2Login(Customizer.withDefaults())
	 * .csrf(ServerHttpSecurity.CsrfSpec::disable) .build(); }
	 */
}
