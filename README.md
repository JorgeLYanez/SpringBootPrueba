# 📦 CRUD de Inventario con Spring Boot y PostgreSQL

Este proyecto es una aplicación CRUD (Create, Read, Update, Delete) para gestionar un inventario de refacciones de vehículos. Utiliza **Spring Boot** para la lógica de backend y **PostgreSQL** como base de datos.

---

## Tecnologías Utilizadas

- **Java 24**
- **Spring Boot 3.4.4**
- **Spring Data JPA**
- **PostgreSQL**
- **Hibernate**
- **Maven**


---

## Endpoints Disponibles

| Método | Endpoint             | Descripción               |
|--------|----------------------|---------------------------|
| GET    | `/api/v1/producto`         | Listar todos los productos |
| GET    | `/api/v1/producto/{id}`    | Obtener un producto por ID |
| POST   | `/api/v1/producto/new`         | Crear un nuevo producto |
| PUT    | `/api/v1/producto/edit/{id}`    | Actualizar un producto |
| DELETE | `/api/v1/producto/delete/{id}`    | Eliminar un producto |

---

## 🔧 Mejoras Futuras
- Implementar autenticación con Spring Security o JWT
- Agregar Swagger para documentación de la API
- Crear un frontend con Angular

