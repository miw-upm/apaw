# ==== Stage 1: build ====
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml ./
RUN mvn -B dependency:go-offline

COPY src ./src
RUN mvn -B -DskipTests package && cp target/*.jar /app/app.jar

# ==== Stage 2: runtime ====
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN addgroup -S app && adduser -S app -G app
COPY --from=build /app/*.jar app.jar
USER app

EXPOSE 8088
HEALTHCHECK --interval=120s --timeout=5s --start-period=20s --retries=3 \
  CMD wget -qO- http://localhost:8088/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar app.jar"]