
# Use an official JDK base image
FROM eclipse-temurin:17-jdk AS build

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml mvnw ./
COPY .mvn .mvn
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Use a lightweight JDK/JRE image for running the application
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar spring-boot-ems-backend.jar

# Expose application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "spring-boot-ems-backend.jar"]