# Étape 1 : construire le projet avec Maven et JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : exécuter le JAR avec un JRE 21 léger
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render fournit le port via la variable d'environnement $PORT
EXPOSE 5000
CMD ["java", "-jar", "app.jar"]
