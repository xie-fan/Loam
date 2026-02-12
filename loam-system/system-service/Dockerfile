FROM maven:3.9.12-eclipse-temurin-25 AS builder

WORKDIR /workspace

COPY Loam/pom.xml Loam/pom.xml
COPY Loam/loam-common Loam/loam-common
COPY Loam/loam-auth Loam/loam-auth
COPY Loam/loam-gateway Loam/loam-gateway
COPY Loam/loam-system Loam/loam-system
COPY Loam/module Loam/module

RUN mvn -f Loam/pom.xml -pl loam-system/system-service -am -DskipTests package

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /workspace/Loam/loam-system/system-service/target/system-service-*.jar /app/system-service.jar

EXPOSE 11001

ENTRYPOINT ["java", "-jar", "/app/system-service.jar"]
