🏨 Login Auth Service - Microservicio de Gestión de Usuarios y Autenticación

Este proyecto es un microservicio desarrollado con Spring Boot, encargado de la autenticación de usuarios y la gestión básica de los mismos (crear usuarios, obtener lista de usuarios) dentro de una plataforma de reservas.

🧩 Arquitectura de Paquetes

com.jao.booking
 ├── entity
 │    ├── UserEntity.java
 │    ├── RoleEntity.java
 │    ├── PermissionEntity.java
 │    ├── PasswordHistoryEntity.java
 │    └── AuditLogEntity.java
 ├── repository
 │    ├── UserRepository.java
 │    ├── RoleRepository.java
 │    ├── PermissionRepository.java
 │    ├── PasswordHistoryRepository.java
 │    └── AuditLogRepository.java
 ├── service
 │    ├── UserService.java
 │    ├── RoleService.java
 │    ├── AuthService.java
 │    └── impl
 │         ├── UserServiceImpl.java
 │         ├── RoleServiceImpl.java
 │         └── AuthServiceImpl.java
 ├── controller
 │    ├── UserController.java
 │    └── AuthController.java
 ├── dto
 │    ├── UserDto.java
 │    ├── RoleDto.java
 │    ├── LoginRequestDto.java
 │    ├── LoginResponseDto.java
 │    ├── PasswordChangeRequestDto.java
 │    └── UserCreateDto.java
 └── mapper
      ├── UserMapper.java
      
🚀 Tecnologías Utilizadas

Java 17+

Spring Boot 3.x

Spring Data JPA

H2 / MySQL / PostgreSQL (configurable)

Spring Security + OAuth2 / Keycloak

Lombok

Maven

MapStruct / Manual Mapper

Swagger / OpenAPI (opcional)

📦 Entidades Implementadas

UserEntity → Información principal del usuario (username, email, passwordHash, status, roles, etc.)

RoleEntity → Roles de usuario (ROLE_USER, ROLE_ADMIN)

UserStatus (Enum) → ACTIVE, INACTIVE, BLOCKED

UserDto → DTO para exponer información del usuario

LoginRequestDto → DTO de petición para login

LoginResponseDto → DTO de respuesta del login

📡 Endpoints REST
AuthController

POST /api/auth/login → Autenticación de usuarios

Ejemplo:
POST /api/auth/login
{
    "username": "juan",
    "password": "123456"
}
Respuesta:
{
    "user": {
        "id": "uuid-del-usuario",
        "username": "juan",
        "email": "juan@email.com",
        "roles": ["ROLE_USER"]
    },
    "token": "jwt-token",
    "message": "Login exitoso"
}
UserController

GET /api/login → Obtener todos los usuarios

GET /api/login/{id} → Obtener un usuario por ID

PATCH /api/login/{id}/password → Cambiar contraseña de un usuario

POST /api/login/create-user → Crear un nuevo usuario

Ejemplo de crear usuario:

POST /api/login/create-user
{
  "user": {
      "username": "joseantorioarana",
      "email": "joseantonioarana@gmail.com",
      "roles": ["ROLE_USER"]
  },
  "password": "joseantorioarana"
}

Respuesta:
{
  "id": "uuid-del-usuario",
  "username": "joseantorioarana",
  "email": "joseantonioarana@gmail.com",
  "roles": ["ROLE_USER"]
}
Ejemplo de cambiar contraseña:
PATCH /api/login/{id}/password
{
  "oldPassword": "contraseñaAnterior",
  "newPassword": "nuevaContraseña123"
}
🧪 Ejemplos JSON (Postman)
Crear usuario:
POST /api/login/create-user
{
  "user": {
      "username": "juan",
      "email": "juan@email.com",
      "roles": ["ROLE_USER"]
  },
  "password": "123456"
}

Login de usuario:
POST /api/auth/login
{
    "username": "juan",
    "password": "123456"
}
🔑 Integración con API Gateway

Ruta /api/auth/** → Enrutada al microservicio login-auth-ms

Ruta /api/login/** → Enrutada al microservicio login-auth-ms

Nota: En Gateway se recomienda definir rutas separadas para /api/auth/** y /api/login/** para evitar problemas de enrutamiento.

📚 Autor

Desarrollado por Juan Arana Olalde (jao)
Backend Engineer especializado en sistemas distribuidos y microservicios.

🛡️ Licencia

Este proyecto está licenciado bajo la licencia MIT
.
Puedes usar, modificar y redistribuir el código bajo los términos de esta licencia.






     