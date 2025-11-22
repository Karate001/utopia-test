# Étape 1 : construire le projet avec Maven et JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : exécuter le JAR avec un JRE 21 léger
FROM eclipse-temurin:21-jre
WORKDIR /app
# Ici tu copies ton vrai JAR
COPY --from=build /app/target/api__projet_e-commerce-0.0.1-SNAPSHOT.jar api__projet_e-commerce.jar

# Port dynamique (Render fournit $PORT)
EXPOSE 5000
CMD ["java", "-jar", "api__projet_e-commerce.jar"]
