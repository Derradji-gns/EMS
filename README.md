# Employee Management System (EMS)
 
> Secure Employee Management System REST API built with Spring Boot and PostgreSQL, featuring JWT authentication, role-based access control (Admin/User), DTO-based architecture, server-side validation, global exception handling, and full CRUD operations following OOP and layered-architecture principles.
 
## Overview
 
EMS is a secure RESTful backend application built with **Spring Boot** and **PostgreSQL** for managing employee data within an organization. It supports two roles, **Admin** and **User**, each with its own permissions. The project follows clean architecture principles and applies industry-standard backend practices: stateless JWT authentication, role-based access control, layered design, and consistent error handling.
 
## Key Features
 
- **Authentication & Authorization (RBAC):** Spring Security enforces role-based access. Admins have full control over employee records, while Users have restricted, read-only or self-service access.
- **Signup & Login with JWT:** New users register and receive a signed token on login. The stateless token is validated on every request through a custom security filter. Passwords are hashed with BCrypt.
- **CRUD APIs:** Complete RESTful endpoints to create, read, update, and delete employees, with pagination, sorting, and search.
- **Server-Side Validation:** Incoming requests are validated with Jakarta Bean Validation (`@NotBlank`, `@Email`, `@Size`, etc.), so invalid data never reaches the business logic.
- **DTOs:** Request and response objects are separated from JPA entities, preventing sensitive fields from leaking and decoupling the API contract from the database model. Mapping can be done with MapStruct or manually.
- **Global Error Handling:** A centralized `@RestControllerAdvice` returns structured, meaningful JSON responses with proper HTTP status codes for validation errors, authentication failures, access denied, and resource-not-found cases.
- **Object-Oriented Programming (OOP):** The code applies encapsulation, abstraction, inheritance, and polymorphism, along with SOLID principles. It uses a layered architecture (Controller → Service → Repository) with interfaces and dependency injection.
## Tech Stack
 
| Layer | Technology |
|---|---|
| Framework | Spring Boot |
| Security | Spring Security, JWT |
| Database | PostgreSQL |
| Persistence | Spring Data JPA / Hibernate |
| Validation | Jakarta Bean Validation |
| Build Tool | Maven / Gradle |
| API Testing | Postman / Swagger (OpenAPI) |
 
## Role Permissions
 
| Action | Admin | User |
|---|---|---|
| Register / Login | ✅ | ✅ |
| View employees | ✅ | ✅ |
| Create employee | ✅ | ❌ |
| Update employee | ✅ | ❌ (own profile only, optional) |
| Delete employee | ✅ | ❌ |
 
## Architecture
 
```
Controller  →  Service  →  Repository  →  PostgreSQL
    ↑             ↑
   DTOs      Business logic
```
 
## Author
 
Derradji Amine Abdelbasset – [Website]www.derradjiamine.me
