# ============================================================================
# Build stage
# ============================================================================
FROM maven:3.9.10-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY application/pom.xml application/
COPY module-academics/pom.xml module-academics/
COPY module-finance/pom.xml module-finance/
COPY module-notifications/pom.xml module-notifications/
COPY module-student-affairs/pom.xml module-student-affairs/

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn clean package -DskipTests

# ============================================================================
# Runtime stage
# ============================================================================
FROM eclipse-temurin:21-jre-alpine-3.21

WORKDIR /app
COPY --from=build /app/application/target/application-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
