# Venta de Pasajes - Backend API con Spring Boot

API REST desarrollada con Java y Spring Boot para la gestión completa de venta de pasajes aéreos. Incluye autenticación JWT, gestión de vuelos, pasajeros, reservas y asientos, con seguridad basada en roles y documentación Swagger.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Security con JWT
- Spring Data JPA
- H2 Database (entorno de desarrollo)
- Swagger/OpenAPI para documentación
- Maven para gestión de dependencias
- JUnit y Mockito para testing

---

## Arquitectura y estructura

- **Entidades:** Modelos JPA con relaciones bien definidas (`Vuelo`, `Pasaje`, `Persona`, `Asiento`, `Usuario`, etc.)
- **Controladores:** REST endpoints organizados en `/api/v1/`, utilizan DTOs para manejar solicitudes y respuestas
- **Servicios:** Lógica de negocio central, integrando repositorios y validaciones
- **Seguridad:** Autenticación y autorización JWT con roles para proteger rutas y operaciones
- **Excepciones:** Manejo centralizado de errores con mensajes claros y códigos HTTP adecuados
- **Configuración:** Swagger para facilitar pruebas y documentación, CORS configurado para permitir frontend

---

## Funcionalidades principales

- Registro y login de usuarios con roles
- CRUD de vuelos, personas, pasajes y asientos
- Asignación de asientos en pasajes
- Búsqueda y paginación en endpoints
- Seguridad basada en JWT para proteger recursos
- Documentación interactiva de API via Swagger UI
- Base de datos en memoria (H2) para desarrollo y testing

---

## Cómo ejecutar

1. Cloná el repositorio:

```bash
git clone https://github.com/jazminaliaga/venta-pasajes.git
```

2. Abrí el proyecto en tu IDE favorito (IntelliJ, Eclipse, VSCode).

3. Ejecutá la clase principal:

```
com.example.venta_pasajes.VentaPasajesApplication
```
---
## Endpoints destacados

| Método | Endpoint	                        | Descripción                          |
|--------|----------------------------------|--------------------------------------|
| POST	 | /api/v1/auth/login	              | Login y generación de token JWT      |
| POST	 | /api/v1/auth/register	          | Registro de nuevos usuarios          |
| GET	   | /api/v1/vuelos	                  | Listar vuelos                        |
| POST   | /api/v1/vuelos	                  | Crear un nuevo vuelo                 |
| GET	   | /api/v1/pasajes                  |	Listar pasajes                       | 
| POST	 | /api/v1/pasajes	                | Crear reserva/pasaje                 |
| GET	   | /api/v1/personas	                | Listar personas/pasajeros            |
| GET	   | /api/v1/asientos	                | Listar asientos disponibles          |
| GET	   | /api/v1/usuarios	                | Gestión de usuarios (admin)          |

---

## Autora
*Jazmín Aliaga*

📧 jazmin.aliaga95@gmail.com

🌐 https://www.linkedin.com/in/jazmin-aliaga/
