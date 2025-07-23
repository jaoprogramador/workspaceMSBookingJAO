package com.jao.booking.config;

import feign.RequestInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(feign.RequestTemplate template) {
        // Obtén el token JWT del contexto de seguridad actual
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
            String token = jwtAuth.getToken().getTokenValue();
            template.header("Authorization", "Bearer " + token);
        }
    }
}

