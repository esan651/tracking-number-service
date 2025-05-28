# Stage 1: Build the jar
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: Run the jar
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the jar from the build stage (adjust name if needed)
COPY --from=build /app/target/tracking-number-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (default for Spring Boot WebFlux is 8080)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
