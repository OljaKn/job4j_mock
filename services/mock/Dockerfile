FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar /app/mock.jar
EXPOSE 9912
ENTRYPOINT ["java", "-jar", "/app/mock.jar"]