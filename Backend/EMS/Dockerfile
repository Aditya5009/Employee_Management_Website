FROM openjdk:21
LABEL maintainer="code_with_aditya"
ADD target/ems-backend-0.0.1-SNAPSHOT.jar spring-boot-ems-backend.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "spring-boot-ems-backend.jar" ]