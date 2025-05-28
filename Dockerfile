# ---- Build Stage ----
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests && ls -lh /app/target

# ---- Run Stage ----
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Debugging: list contents copied from build stage
COPY --from=build /app/target/tracking-number-service-0.0.1-SNAPSHOT.jar app.jar
RUN ls -lh /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
