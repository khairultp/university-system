# University System

A comprehensive university management system built with Spring Boot, designed to handle various aspects of university operations including student affairs, academics, finance, and notifications.

## Modular Monolith Architecture

This project implements a modular monolith architecture, which combines the simplicity of monolithic deployment with the maintainability of a modular codebase:

- **Single Deployment Unit**: The entire application is deployed as a single unit, simplifying operations and deployment processes
- **Modular Code Organization**: Code is organized into separate modules with clear boundaries
- **Internal Module Independence**: Each module has its own domain model, services, and APIs
- **Explicit Module Dependencies**: Dependencies between modules are explicitly defined in the POM files
- **Shared Database**: All modules share a single database but maintain their own tables and schemas

This approach offers several benefits:
- Simplified deployment and operations compared to microservices
- Clear code organization and separation of concerns
- Ability to evolve modules independently
- Easier refactoring and maintenance
- Potential future migration path to microservices if needed

## System Architecture

The system is built as a **Modular Monolith**, separating concerns into distinct modules while maintaining deployment as a single application:

![System Architecture](architecture.png)

## Modules

- **Application**: Main application module that bootstraps the entire system
- **Student Affairs**: Manages student records and information
- **Academics**: Handles course registration and academic operations
- **Finance**: Manages billing and payment processing
- **Notifications**: Handles system notifications and alerts

## Project Structure

![Project Structure](project-structure.png)

## Technologies Used

- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database (in-memory)
- Swagger/OpenAPI for API documentation

## Setup and Installation

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Building the Project

```bash
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run -pl application
```

## API Documentation

### Swagger UI

The API documentation is available via Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

### Available Endpoints

#### Student Affairs

- **Create Student**
  - Endpoint: `POST /api/students`
  - Description: Creates a new student record
  - Sample Request:
    ```bash
    curl -X POST http://localhost:8080/api/students \
      -H "Content-Type: application/json" \
      -d '{
        "name": "John Doe",
        "email": "john.doe@example.com",
        "active": true
      }'
    ```

#### Academics

- **Register for Courses**
  - Endpoint: `POST /api/registration`
  - Description: Registers a student for courses
  - Sample Request:
    ```bash
    curl -X POST http://localhost:8080/api/registration \
      -H "Content-Type: application/json" \
      -d '{
        "studentId": 1,
        "courseIds": [101, 102, 103]
      }'
    ```

## Database Access

The application uses an H2 in-memory database. You can access the H2 console at:

```
http://localhost:8080/h2-console
```

Connection details:
- JDBC URL: `jdbc:h2:mem:university`
- Username: `sa`
- Password: (leave empty)

## Error Handling

The system includes centralized error handling for common exceptions:

- `StudentNotFoundException`: Returns 404 Not Found
- `StudentNotActiveException`: Returns 403 Forbidden
- `OutstandingPaymentsException`: Returns 403 Forbidden
