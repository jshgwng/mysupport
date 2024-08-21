FROM openjdk:17-jdk-slim

WORKDIR /app

COPY out/artifacts/mysupport_jar/mysupport.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]



