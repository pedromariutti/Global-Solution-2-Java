FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY . /app
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/quarkus-app/quarkus-run.jar"]