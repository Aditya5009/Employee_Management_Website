FROM openjdk:21

WORKDIR /app

COPY target/ems-backend-0.0.1-SNAPSHOT.jar spring-boot-ems-backend.jar

EXPOSE 8080

CMD [ "java", "-jar", "spring-boot-ems-backend.jar" ]