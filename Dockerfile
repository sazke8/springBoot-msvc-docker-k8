FROM arm64v8/openjdk:17-ea-16-jdk AS maven-builder
WORKDIR /app/msvc-usuarios
COPY ./pom.xml /app
COPY ./msvc-usuarios/.mvn ./.mvn
COPY ./msvc-usuarios/mvnw .
COPY ./msvc-usuarios/pom.xml .
RUN ./mvnw clean package  -Dmaven.test.skip  -Dmaven.main.skip  -Dspring-boot.repackage.skip && rm -r ./target/
COPY ./msvc-usuarios/src ./src
RUN ./mvnw clean package  -DskipTests

FROM arm64v8/openjdk:17-ea-16-jdk
WORKDIR /app
RUN mkdir ./logs
COPY --from=maven-builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
EXPOSE 8001
CMD ["java", "-jar","msvc-usuarios-0.0.1-SNAPSHOT.jar"]