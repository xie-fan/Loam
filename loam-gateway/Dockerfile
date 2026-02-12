FROM maven:3.9.12-eclipse-temurin-25 AS builder

WORKDIR /workspace

COPY Loam/pom.xml Loam/pom.xml
COPY Loam/loam-common Loam/loam-common
COPY Loam/loam-auth Loam/loam-auth
COPY Loam/loam-gateway Loam/loam-gateway
COPY Loam/loam-system Loam/loam-system
COPY Loam/module Loam/module

RUN mvn -f Loam/pom.xml -pl loam-gateway -am -DskipTests package

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /workspace/Loam/loam-gateway/target/loam-gateway-*.jar /app/loam-gateway.jar

EXPOSE 11000

ENTRYPOINT ["java", "-jar", "/app/loam-gateway.jar"]
