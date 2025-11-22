# Étape 1 : build avec Maven + JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : runtime JRE 21 léger
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose un port arbitraire (Render ignore)
EXPOSE 8080

# Définit une valeur par défaut pour le port si Render ne le fournit pas
ENV PORT=8080

# Lancer Spring Boot en utilisant le port fourni par Render
CMD ["java", "-jar", "app.jar", "--server.port=${PORT}"]
