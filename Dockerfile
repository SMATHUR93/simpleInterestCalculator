# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

COPY target/simpleInterestCalculator-0.0.1-SNAPSHOT.jar /app/simpleInterestCalculator-0.0.1-SNAPSHOT.jar

EXPOSE 5001

CMD ["java", "-jar", "/app/simpleInterestCalculator-0.0.1-SNAPSHOT.jar"]