# -------- Build stage --------
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy pom and source files
COPY . .

# Build the project and print output to verify
RUN mvn clean package -DskipTests && \
    echo "==== JAR FILES ====" && \
    ls -lh target

# -------- Runtime stage --------
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the built jar (match your artifactId and version from pom.xml)
COPY --from=build /app/target/tracking-number-service-0.0.1-SNAPSHOT.jar app.jar

# Optional: Verify it exists
RUN ls -lh /app

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
