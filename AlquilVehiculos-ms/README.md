# 🏨 Booking Service - Microservicio de Gestión de Usuarios

Este proyecto es un microservicio desarrollado con **Spring Boot**, encargado de gestionar usuarios, direcciones, datos bancarios y preferencias dentro de una plataforma de reservas.

---

## 🧩 Arquitectura de Paquetes
com.jao.booking
├── controller # Controladores REST
├── model # Objetos de transferencia de datos (DTOs)
├── entity # Entidades JPA
├── exception # Manejo de excepciones personalizadas
├── mapper # Conversores entre Entity <-> DTO (MapStruct o manual)
├── repository # Interfaces JPA Repositories
├── service # Interfaces de lógica de negocio
├── service.impl # Implementaciones de lógica de negocio
└── resources
└── application.properties


---

## 🚀 Tecnologías Utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Lombok
- Maven
- H2 / MySQL / PostgreSQL (según entorno)
- MapStruct (opcionalmente manual mapping)
- Swagger / OpenAPI (documentación)
- Spring Validation
- Spring Actuator

---

## 📦 Entidades Implementadas

| Entidad                    | Descripción                                      |
|---------------------------|--------------------------------------------------|
| `UsuarioEntity`           | Información principal del usuario                |
| `DireccionEntity`         | Direcciones físicas asociadas a un usuario       |
| `DatosBancariosEntity`    | Cuentas bancarias de un usuario                  |
| `PreferenciaUsuarioEntity`| Preferencias personales (idioma, notificaciones) |
| `RolUsuario` (Enum)       | CLIENTE, ADMIN, OPERADOR                         |

---

## 📡 Endpoints REST

### `UsuarioController`
- `GET /api/usuarios`
- `GET /api/usuarios/{id}`
- `POST /api/usuarios`
- `DELETE /api/usuarios/{id}`

### `DireccionController`
- `GET /api/direcciones`
- `GET /api/direcciones/{id}`
- `POST /api/direcciones`
- `DELETE /api/direcciones/{id}`

### `DatosBancariosController`
- `GET /api/datos-bancarios`
- `GET /api/datos-bancarios/{id}`
- `POST /api/datos-bancarios`
- `DELETE /api/datos-bancarios/{id}`

### `PreferenciaUsuarioController`
- `GET /api/preferencias`
- `GET /api/preferencias/{id}`
- `POST /api/preferencias`
- `DELETE /api/preferencias/{id}`

---

## 🧪 Ejemplos JSON (Postman)

### Crear preferencia:
```json
POST /api/preferencias
{
  "idioma": "es",
  "recibirNotificaciones": true,
  "usuarioId": 1
}
POST /api/direcciones
{
  "calle": "Gran Via",
  "ciudad": "Madrid",
  "provincia": "Madrid",
  "codigoPostal": "28013",
  "pais": "España"
}
POST /api/direcciones
{
  "calle": "Gran Via",
  "ciudad": "Madrid",
  "provincia": "Madrid",
  "codigoPostal": "28013",
  "pais": "España"
}

POST /api/datos-bancarios
{
  "titular": "Juan Pérez",
  "numeroCuenta": "ES7620770024003102575766",
  "banco": "BBVA",
  "swiftBic": "BBVAESMMXXX",
  "tipoCuenta": "Corriente",
  "activo": true
}
{
  "spring.datasource.username": "gestHoteles_user",
  "spring.datasource.password": "gestHoteles_pass",
  "spring.datasource.url": "jdbc:mysql://localhost:3311/gestHoteles_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
}
## 📚 Autor

Desarrollado por **Juan Arana Olalde (jao)**  
Backend Engineer especializado en sistemas distribuidos y microservicios.

## 🛡️ Licencia

Este proyecto está licenciado bajo la licencia [MIT](LICENSE).  
Puedes usar, modificar y redistribuir el código bajo los términos de esta licencia.


