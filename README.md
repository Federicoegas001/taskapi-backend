# Task API Backend

API REST de gestión de tareas construida con Java y Spring Boot.

## Demo
[Swagger UI](https://taskapi-backend-production-177d.up.railway.app/swagger-ui/index.html)

## Stack
- Java 17
- Spring Boot 4
- MySQL + JPA/Hibernate
- Spring Security + JWT
- Lombok
- Maven

## Funcionalidades
- Registro y login de usuarios con JWT
- CRUD completo de tareas
- Validaciones y manejo de errores
- Documentación con Swagger

## Endpoints principales

| Método | URL | Descripción |
|--------|-----|-------------|
| POST | /auth/register | Registrar usuario |
| POST | /auth/login | Iniciar sesión |
| GET | /api/tasks | Obtener todas las tareas |
| POST | /api/tasks | Crear tarea |
| PUT | /api/tasks/{id} | Actualizar tarea |
| DELETE | /api/tasks/{id} | Eliminar tarea |

## Correr localmente
1. Clonar el repositorio
2. Configurar `application.properties` con tu base de datos MySQL
3. Ejecutar con IntelliJ o `./mvnw spring-boot:run`
