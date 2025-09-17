package com.jao.booking.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.jao.booking.entity.UserEntity;
import com.jao.booking.entity.UserStatus;
import com.jao.booking.mapper.UserMapper;
import com.jao.booking.model.LoginRequestDto;
import com.jao.booking.model.LoginResponseDto;
import com.jao.booking.repository.UserRepository;
import com.jao.booking.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	

	/*
	 * private final WebClient webClient;
	 * 
	 * @Value("${keycloak.auth-server-url}") private String keycloakUrl;
	 * 
	 * @Value("${keycloak.realm}") private String realm;
	 * 
	 * @Value("${keycloak.resource}") private String clientId;
	 * 
	 * @Value("${keycloak.credentials.secret}") private String clientSecret;
	 * 
	 * public AuthServiceImpl(WebClient.Builder webClientBuilder) { //this.webClient
	 * = webClientBuilder.build(); this.webClient = WebClient.create(); }
	 * 
	 * @Override public LoginResponseDto login(LoginRequestDto loginRequest) {
	 * KeycloakTokenResponse tokenResponse = webClient.post() .uri(keycloakUrl +
	 * "/realms/" + realm + "/protocol/openid-connect/token")
	 * .header("Content-Type", "application/x-www-form-urlencoded")
	 * .bodyValue("grant_type=password&client_id=" + clientId + "&client_secret=" +
	 * clientSecret + "&username=" + loginRequest.getUsername() + "&password=" +
	 * loginRequest.getPassword()) .retrieve()
	 * .bodyToMono(KeycloakTokenResponse.class) .block();
	 * 
	 * if (tokenResponse == null) { throw new
	 * RuntimeException("Error autenticando con Keycloak"); }
	 * 
	 * return new LoginResponseDto(tokenResponse.getAccessToken(),
	 * tokenResponse.getRefreshToken()); }
	 */
	
private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	private final UserRepository userRepository;
    private final UserMapper userMapper;
    
	@Override
    public LoginResponseDto login(LoginRequestDto request) {
		String token=null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null && authentication.getCredentials() instanceof Jwt jwt) {
	        token = jwt.getTokenValue();
	    }
	    log.info("Obtenemos el token ={}", token);
        String username = request.getUsername();
        String rawPassword = request.getPassword();

        log.info("Validando credenciales para username={}", username);

        // 1. Buscar usuario
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // 2. Validar estado del usuario
        if (user.getStatus() != UserStatus.ACTIVE) {
            log.warn("Usuario {} no está activo", username);
            throw new BadCredentialsException("Usuario bloqueado o inactivo");
        }

        // 3. Validar contraseña con BCrypt
        boolean passwordOk = BCrypt.checkpw(rawPassword, user.getPasswordHash());
        if (!passwordOk) {
            log.warn("Password incorrecto para username={}", username);
            throw new BadCredentialsException("Credenciales inválidas");
        }

        log.info("Usuario {} autenticado correctamente", username);

        // 4. Construir respuesta (sin token)
        return LoginResponseDto.builder()
                .user(userMapper.toDto(user))
                .token(token)
                //.message("Login exitoso")
                .build();
    }
}

