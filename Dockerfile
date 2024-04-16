FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean install
RUN mv /target/*.jar /target/api.jar
EXPOSE 8080
CMD ["java", "-jar", "/target/api.jar"]