FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/santander-challenge-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
