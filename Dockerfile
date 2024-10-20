FROM eclipse-temurin:21-jdk as builder
WORKDIR /app
COPY . /app/.
# clean up the file
RUN sed -i 's/\r$//' mvnw
RUN /bin/sh ./mvnw -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM builder
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 8080
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app/*.jar"]