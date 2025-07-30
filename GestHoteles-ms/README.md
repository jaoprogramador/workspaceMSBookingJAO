# 🏨 GestHoteles Microservicio

Microservicio para la **gestión de hoteles** dentro de una arquitectura basada en microservicios para un sistema de reservas tipo Booking. Este servicio administra información relacionada con hoteles, habitaciones, direcciones, imágenes, disponibilidades, políticas y reseñas de usuarios.

---

## 📦 Módulos del Microservicio

### 🔸 Entidades Principales (`entity/`)
- `HotelEntity`: Información general del hotel.
- `HabitacionEntity`: Detalle de cada habitación del hotel.
- `DireccionEntity`: Dirección física del hotel.
- `DisponibilidadEntity`: Fechas disponibles de las habitaciones.
- `ImagenEntity`: Galería de imágenes del hotel.
- `PoliticaEntity`: Políticas del hotel (cancelación, mascotas, fumar, etc).
- `ResenaEntity`: Reseñas de los usuarios sobre el hotel.

---

## 📂 Estructura de Paquetes

---

## 🚀 Tecnologías Utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Lombok
- H2 / MySQL / PostgreSQL (configurable)
- Maven
- MapStruct (opcional para mapping DTO/Entity)
- Swagger (opcional para documentación)

---

## 📑 Endpoints Principales

| Entidad      | Endpoint Base         | Ejemplos de operaciones                         |
|--------------|-----------------------|-------------------------------------------------|
| Hotel        | `/api/hoteles`        | CRUD completo de hoteles                        |
| Habitacion   | `/api/habitaciones`   | Gestión de habitaciones por hotel               |
| Direccion    | `/api/direcciones`    | CRUD de direcciones de hoteles                  |
| Disponibilidad | `/api/disponibilidades` | Fechas disponibles de habitaciones         |
| Imagen       | `/api/imagenes`       | Subida y gestión de imágenes de hoteles         |
| Política     | `/api/politicas`      | Registro de políticas de cada hotel             |
| Reseña       | `/api/resenas`        | Opiniones y puntuaciones de usuarios            |

> Todos los endpoints aceptan y devuelven datos en formato **JSON**.

---

## 📥 Ejemplo JSON para crear un hotel

com.jao.alquilerhoteles
│
├── controller # Exposición de endpoints REST
├── dto # Objetos de transferencia de datos
├── entity # Entidades JPA (modelos de base de datos)
├── mapper # Conversión entre entidad y DTO
├── repository # Interfaces de persistencia JPA
└── service # Lógica de negocio y orquestación


---

## 🚀 Tecnologías Utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Lombok
- H2 / MySQL / PostgreSQL (configurable)
- Maven
- MapStruct (opcional para mapping DTO/Entity)
- Swagger (opcional para documentación)

---

## 📑 Endpoints Principales

| Entidad      | Endpoint Base         | Ejemplos de operaciones                         |
|--------------|-----------------------|-------------------------------------------------|
| Hotel        | `/api/hoteles`        | CRUD completo de hoteles                        |
| Habitacion   | `/api/habitaciones`   | Gestión de habitaciones por hotel               |
| Direccion    | `/api/direcciones`    | CRUD de direcciones de hoteles                  |
| Disponibilidad | `/api/disponibilidades` | Fechas disponibles de habitaciones         |
| Imagen       | `/api/imagenes`       | Subida y gestión de imágenes de hoteles         |
| Política     | `/api/politicas`      | Registro de políticas de cada hotel             |
| Reseña       | `/api/resenas`        | Opiniones y puntuaciones de usuarios            |

> Todos los endpoints aceptan y devuelven datos en formato **JSON**.

---

## 📥 Ejemplo JSON para crear un hotel

```json
{
  "nombre": "Hotel del Mar",
  "descripcion": "Frente al mar, ideal para vacaciones",
  "categoria": 4,
  "telefono": "+34123456789",
  "email": "contacto@hoteldelmar.com"
}
## 📚 Autor

Desarrollado por **Juan Arana Olalde (jao)**  
Backend Engineer especializado en sistemas distribuidos y microservicios.

## 🛡️ Licencia

Este proyecto está licenciado bajo la licencia [MIT](LICENSE).  
Puedes usar, modificar y redistribuir el código bajo los términos de esta licencia.






