package com.jao.booking.service.impl;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jao.booking.entity.PasswordHistoryEntity;
import com.jao.booking.entity.RoleEntity;
import com.jao.booking.entity.UserEntity;
import com.jao.booking.entity.UserStatus;
import com.jao.booking.mapper.UserMapper;
import com.jao.booking.model.PasswordChangeRequestDto;
import com.jao.booking.model.UserDto;
import com.jao.booking.repository.PasswordHistoryRepository;
import com.jao.booking.repository.RoleRepository;
import com.jao.booking.repository.UserRepository;
import com.jao.booking.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordHistoryRepository passwordHistoryRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    public UserServiceImpl(UserRepository userRepository,
    		RoleRepository roleRepository,
                           PasswordHistoryRepository passwordHistoryRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

        this.passwordHistoryRepository = passwordHistoryRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto, String rawPassword) {
        log.info("Creando usuario con username={}", userDto.getUsername());

        // Hash de contraseña
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
     
        // Mapear DTO a Entity
        UserEntity entity = userMapper.toEntity(userDto);
     // Generar salt obligatorio
        entity.setSalt(generateSalt());
        entity.setPasswordHash(hashedPassword);
        entity.setStatus(UserStatus.ACTIVE);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        // Buscar roles existentes en la base de datos
        if (userDto.getRoles() != null && !userDto.getRoles().isEmpty()) {
            Set<RoleEntity> roles = roleRepository.findByNameIn(userDto.getRoles());
            entity.setRoles(roles);
        }

        // Guardar usuario
        UserEntity saved = userRepository.save(entity);

        // Guardar historial de password
        PasswordHistoryEntity history = PasswordHistoryEntity.builder()
                .user(saved)
                .oldPasswordHash(saved.getPasswordHash())
                .changedAt(LocalDateTime.now())
                .build();
        passwordHistoryRepository.save(history);

        log.info("Usuario creado con id={}", saved.getId());
        return userMapper.toDto(saved);
    }

	/*
	 * public UserDto createUser(UserDto userDto, String rawPassword) {
	 * log.info("Creando usuario con username={}", userDto.getUsername()); // Hash
	 * de contraseña String hashedPassword = BCrypt.hashpw(rawPassword,
	 * BCrypt.gensalt(12));
	 * 
	 * UserEntity entity = userMapper.toEntity(userDto);
	 * entity.setPasswordHash(hashedPassword);
	 * entity.setStatus(com.jao.booking.entity.UserStatus.ACTIVE);
	 * entity.setCreatedAt(LocalDateTime.now());
	 * entity.setUpdatedAt(LocalDateTime.now());
	 * 
	 * UserEntity saved = userRepository.save(entity);
	 * 
	 * // Guardar historial de password PasswordHistoryEntity history =
	 * PasswordHistoryEntity.builder() .user(saved)
	 * .oldPasswordHash(saved.getPasswordHash()) .changedAt(LocalDateTime.now())
	 * .build(); passwordHistoryRepository.save(history);
	 * log.info("Usuario creado con id={}", saved.getId()); return
	 * userMapper.toDto(saved); }
	
    
    public UserDto createUser(UserDto userDto, String rawPassword) {
        log.info("Creando usuario con username={}", userDto.getUsername());

        // Hash de contraseña
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));

        // Convertir DTO a Entity
        UserEntity entity = userMapper.toEntity(userDto);

        // Generar salt obligatorio
        entity.setSalt(generateSalt());

        // Setear el hash y otros campos
        entity.setPasswordHash(hashedPassword);
        entity.setStatus(UserStatus.ACTIVE);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        // Guardar en DB
        UserEntity saved = userRepository.save(entity);

        // Guardar historial de password
        PasswordHistoryEntity history = PasswordHistoryEntity.builder()
                .user(saved)
                .oldPasswordHash(saved.getPasswordHash())
                .changedAt(LocalDateTime.now())
                .build();
        passwordHistoryRepository.save(history);

        log.info("Usuario creado con id={}", saved.getId());
        return userMapper.toDto(saved);
    } */

 // Método auxiliar para generar salt seguro
    private String generateSalt() {
        byte[] saltBytes = new byte[16];
        new SecureRandom().nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    @Override
    public UserDto getUserById(UUID id) {
    	log.info("Buscando usuario por id={}", id);
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<UserDto> getAllUsers() {
    	log.info("Obtener usuarios ");
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public void changePassword(UUID userId, PasswordChangeRequestDto request) {
    	log.info("Cambiar pass al usuario con username={}", userId);
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Validar contraseña actual
        if (!BCrypt.checkpw(request.getOldPassword(), user.getPasswordHash())) {
            throw new RuntimeException("La contraseña actual no es válida");
        }

        // Hash nueva contraseña
        String newHashed = BCrypt.hashpw(request.getNewPassword(), BCrypt.gensalt(12));
        user.setPasswordHash(newHashed);
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
        log.info("Cambiada pass al usuario username={}", userId);
        // Guardar historial
        PasswordHistoryEntity history = PasswordHistoryEntity.builder()
                .user(user)
                .oldPasswordHash(newHashed)
                .changedAt(LocalDateTime.now())
                .build();
        passwordHistoryRepository.save(history);
    }
}

