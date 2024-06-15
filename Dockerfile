FROM amazoncorretto:21
WORKDIR /app
COPY target/your-application.jar /app/your-application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/your-application.jar"]
