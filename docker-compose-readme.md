# Docker Compose for University System

This document provides instructions on how to use Docker Compose to run the University System.

## Prerequisites

- Docker and Docker Compose installed on your machine
- Java 21 and Maven installed for building the application

## Components

The Docker Compose configuration includes the following services:

1. **university-app**: The main modular monolith application
2. **notifications-service**: The standalone notifications microservice
3. **zookeeper**: Required for Kafka
4. **kafka**: The message broker used for communication between services
5. **kafka-ui**: A UI for monitoring Kafka (optional but useful)

## Building the Application

Before running the Docker Compose, you need to build the application JARs:

```bash
# Build the entire project
mvn clean package
```

The `-pl` flag specifies the project/module to build, and `-am` also builds the required dependencies.

## Running the Application

To start all services:

```bash
docker-compose up -d
```

To stop all services:

```bash
docker-compose down
```

## Accessing the Services

- Main Application: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console
- Notifications Service: http://localhost:8081
- Kafka UI: http://localhost:8082

## Environment Variables

The Docker Compose file sets the following environment variables:

### university-app
- SPRING_DATASOURCE_URL=jdbc:h2:mem:university
- SPRING_DATASOURCE_USERNAME=sa
- SPRING_DATASOURCE_PASSWORD=
- SPRING_CLOUD_STREAM_KAFKA_BINDER_BROKERS=kafka:9092
- SPRING_H2_CONSOLE_SETTINGS_WEB_ALLOW_OTHERS=true

### notifications-service
- SERVER_PORT=8081
- SPRING_CLOUD_STREAM_KAFKA_BINDER_BROKERS=kafka:9092
- SPRING_CLOUD_STREAM_KAFKA_BINDER_AUTO_CREATE_TOPICS=true

## Troubleshooting

If you encounter any issues:

1. Check if all containers are running:
   ```bash
   docker-compose ps
   ```

2. Check the logs of a specific service:
   ```bash
   docker-compose logs university-app
   docker-compose logs notifications-service
   docker-compose logs kafka
   ```

3. Ensure that the JAR files exist in the expected locations:
   - ./application/target/application-0.0.1-SNAPSHOT.jar
   - ./notifications-service/target/notifications-service-0.0.1-SNAPSHOT.jar

4. For H2 Console access issues:
   - Make sure you're using the correct JDBC URL: jdbc:h2:mem:university
   - Username: sa
   - Password: (leave empty)
   - The H2 console is configured to allow remote connections with the SPRING_H2_CONSOLE_SETTINGS_WEB_ALLOW_OTHERS=true setting

5. For Kafka connection issues:
   - The Kafka broker is configured with two listeners:
     - PLAINTEXT://kafka:29092 for internal container communication
     - PLAINTEXT_HOST://localhost:9092 for external access
   - Services within Docker should use kafka:29092
   - Applications running on the host machine should use localhost:9092
